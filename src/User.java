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
        book.setCurrentPage(0);
        System.out.println("Press 'n' to read the next page or any other key to stop.");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("n")) {
                book.nextPage();
            } else {
                System.out.println("la lecture de livre " + book.getTitle() + " est arreté a la page " + book.getCurrentPage() + " .");
                break;
            }
        }
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
                System.out.println("la lecture de livre " + book.getTitle() + " est arreté a la page " + book.getCurrentPage() + " .");
                break;
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
