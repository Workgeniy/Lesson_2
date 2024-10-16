import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

class Box { public int a; public String b; }

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Logger logger = new Logger();
//        Logger2 logger2 = new Logger2();
//        Random rand = new Random();
//
//        String[] names = new String[]{"Tom", "Sam", "Alex"};
//        Student[] students = new Student[3];
//
//        for (int i = 0; i < students.length; i++) {
//            int[] marks = new int[5];
//
//            for (int j = 0; j < 5; j++) {
//                marks[j] = rand.nextInt(5);
//            }
//            students[i] = new Student(names[i], marks);
//        }
//
//        String bestStudent = "";
//        String worstStudent = "";
//        int averageMinMarks = 25;
//        int averageMaxMarks = 0;
//        for (Student student : students){
//            int averageMarks = 0;
//            for (int i = 0; i < student.grades.length; i++) {
//                averageMarks += student.grades[i];
//            }
//
//            if (averageMarks > averageMaxMarks){
//                averageMaxMarks = averageMarks;
//                bestStudent = student.name;
//            }
//
//            if (averageMarks < averageMinMarks) {
//                averageMinMarks = averageMarks;
//                worstStudent = student.name;
//            }
//        }
//        System.out.println ("Max " + averageMaxMarks);
//        System.out.println ("Min " +averageMinMarks);
//
//        int difference = averageMaxMarks - averageMinMarks;
//        System.out.println("Разница " + difference);
//        if (difference > 0){
//            int count = 0;
//            for (int i = 0; i < difference; i++) {
//                averageMinMarks += 5;
//                count++;
//                if (averageMinMarks > averageMaxMarks){
//                    logger.castMessage(worstStudent + " нужно " + count + " пятерок, чтобы догнать " + bestStudent);
//                    try {
//                        logger2.castMessage(worstStudent + " нужно " + count + " пятерок, чтобы догнать " + bestStudent);
//                    }
//                    catch (IOException e){
//                        System.out.println(e);
//                    }
//                    break;
//                }
//            }
//        }
//        else {
//            logger.castMessage("Нет худшего или лучшего");
//            try {
//                logger2.castMessage("Нет худшего или лучшего");
//            }
//            catch (IOException e){
//                System.out.println(e);
//            }
//        }

        CollectionMedia media = new CollectionMedia();

        media.Add("text.txt");

        media.Display();

        media.Remove(0);

        media.Display();
    }

}