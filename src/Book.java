import java.io.Serializable;

public class Book implements Serializable {
    public String title;
    public String author;
    public String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre;
    }
}
