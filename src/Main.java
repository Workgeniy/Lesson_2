import java.io.*;
import java.util.*;

class Box { public int a; public String b; }

public class Main {
    public static void main(String[] args) {

//        int[] numbers = {5, 1, 4, 2, 3, 0};
//        Arrays.stream(numbers)
//                .filter(number -> number % 2 == 0)
//                .sorted()
//                .forEach(number -> System.out.println(number));
//
//        System.out.println("-----");
//
//        List<Integer> number = Arrays.asList(5, 1, 4, 2, 3, 0);
//
//        number.stream()
//                .sorted(Collections.reverseOrder())
//                .forEach(num -> System.out.println(num));


        Book[] books = new Book[]{
                new Book("Капитанская дочка", "А. С. Пушкин", "Роман"),
                new Book("Война и мир", "Л. Н. Толстой", "Роман"),
                new Book("Всадник без головы", "Майн Рид", "Роман"),
                new Book("Евгений Онегин", "А. С. Пушкин", "Роман"),
                new Book("Мертвые души", "Н. В. Гоголь", "Роман"),
        };

        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("books.txt"))) {
            stream.writeObject(books);
            System.out.println("Успешно");
        } catch (Exception e) {
            System.out.println("Не записал в файл");
        }

        ArrayList<Book> bookArray  = new ArrayList<>();
        try {
            File file = new File("books.txt");
            ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream(file));
            bookArray = (ArrayList<Book>)streamIn.readObject();
        }
        catch (Exception e) {
            System.out.println("Не нашел файл");
        }

        for (Book book : bookArray) {
            System.out.println(book);
        }

    }
}