
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();
        Random rand = new Random();

        //Определить прошел ли студент
        Predicate<Integer> isExaming = average -> average > 17;

        //Консьюмер печатающий в файл
        Consumer <String> printFile = (message)  -> {
            try (FileWriter file = new FileWriter("resultExam.txt", true)){
                String text = message + "\n";
                file.write(text);

                file.flush();
            }

            catch (IOException e){
                System.out.println(e.getMessage());
            }
        };

        String[] names = new String[]{"Tom", "Sam", "Alex"};
        Student[] students = new Student[3];

        for (int i = 0; i < students.length; i++) {
            int[] marks = new int[5];
            for (int j = 0; j < 5; j++) {
                marks[j] = rand.nextInt(5) + 1;
            }
            students[i] = new Student(names[i], marks);
        }

        String bestStudent = "";
        String worstStudent = "";
        int averageMinMarks = 25;
        int averageMaxMarks = 0;
        for (Student student : students){
            int averageMarks = 0;
            for (int i = 0; i < student.grades.length; i++) {
                averageMarks += student.grades[i];
            }

            if (averageMarks > averageMaxMarks){
                averageMaxMarks = averageMarks;
                bestStudent = student.name;
            }

            if (averageMarks < averageMinMarks) {
                averageMinMarks = averageMarks;
                worstStudent = student.name;
            }


            if (isExaming.test(averageMarks)) {
                    printFile.accept("Студент " +  student.name + " прошел экзамен");
            }
            else {
                    printFile.accept("Студент " +  student.name + " не прошел экзамен");
            }
        }

        int difference = averageMaxMarks - averageMinMarks;

        if (difference > 0){
            int count = 0;
            for (int i = 0; i < difference; i++) {
                averageMinMarks += 5;
                count++;
                if (averageMinMarks > averageMaxMarks){
                    printFile.accept(worstStudent + " нужно " + count + " пятерок, чтобы догнать " + bestStudent);
                    logger.castMessage(worstStudent + " нужно " + count + " пятерок, чтобы догнать " + bestStudent);
                    break;
                }
            }
        }
        else {
            printFile.accept("Нет худшего или лучшего");
            logger.castMessage("Нет худшего или лучшего");
        }


        //Примеры функциональных интерфейсов
        Predicate<Integer> isTrue = x -> x > 10;
        System.out.println(isTrue.test(11));

        UnaryOperator<Integer> plus = x -> x + 2;
        System.out.println(plus.apply(11));

        BinaryOperator<Integer> minus = (x, y) -> x - y;
        System.out.println(minus.apply(10,5));

        Supplier<Integer> test = () -> 10;
        System.out.println(test.get());

        Consumer<String> consumer =(x) -> System.out.println(x + " 12");
        consumer.accept("Hello");
    }

}