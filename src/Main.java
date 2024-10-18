import java.io.*;
import java.util.*;
import java.util.concurrent.*;

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


        ArrayList<Book> books = new ArrayList<Book>();
                books.add(new Book("Капитанская дочка", "А. С. Пушкин", "Роман"));
                books.add(new Book("Война и мир", "Л. Н. Толстой", "Роман"));
                books.add(new Book("Всадник без головы", "Майн Рид", "Роман"));
                books.add(new Book("Евгений Онегин", "А. С. Пушкин", "Роман"));
                books.add(new Book("Мертвые души", "Н. В. Гоголь", "Роман"));


        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("books.txt"))) {
            stream.writeObject(books);
            stream.flush();
            stream.close();
            System.out.println("Успешно");
        } catch (Exception e) {
            System.out.println("Не записал в файл");
        }

        ArrayList<Book> bookArray  = new ArrayList<Book>();
        try {
            FileInputStream file = new FileInputStream("books.txt");
            ObjectInputStream streamIn = new ObjectInputStream(file);
            bookArray = ((ArrayList<Book>) streamIn.readObject());
        }
        catch (Exception e) {
            System.out.println("Не нашел файл");
        }

        for (Book book : bookArray) {
            System.out.println(book);
        }

    }
}