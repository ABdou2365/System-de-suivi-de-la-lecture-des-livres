import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Book> books;

    public User(String username) {
        this.username = username;
        this.books = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void readBook(Book book) {
        // Assume that the User reads the book from the beginning
        book.setCurrentPage(0);
    }

    public void stopReading(Book book) {
        // Assume that the User stops reading at the current page
        System.out.println("Stopped reading " + book.getTitle() + " at page " + book.getCurrentPage());
    }

    public void resumeReading(Book book) {
        // Assume that the User resumes reading from where they left off
        System.out.println("Resuming reading " + book.getTitle() + " from page " + book.getCurrentPage());
    }

    public List<Book> getBooks() {
        return books;
    }
}
