import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void readBook(Book book, Scanner scanner) {
        System.out.println("Reading " + book.getTitle() + "...");
        System.out.println("Press 'n' to read the next page or any other key to stop.");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("n")) {
                book.nextPage();
            } else {
                System.out.println("Stopped reading " + book.getTitle() + ".");
                break;
            }
        }
    }


    public void stopReading(Book book) {
        // Assume that the User stops reading at the current page
        System.out.println("Arrêté de lire " + book.getTitle() + " à la page " + book.getCurrentPage());
    }

    public void resumeReading(Book book, Scanner scanner) {
        // Assume that the User resumes reading from the last read page
        System.out.println("Reprise de la lecture de " + book.getTitle() + " à partir de la page " + book.getCurrentPage());

        System.out.println("Press 'n' to read the next page or any other key to stop.");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("n")) {
                book.nextPage();
            } else {
                System.out.println("Stopped reading " + book.getTitle() + ".");
                break;
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
