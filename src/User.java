import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String username;
    private List<Book> books;

    public User(String username) {
        this.username = username;
        this.books = new ArrayList<>();
        loadBooks();
    }

    public String getUsername() {
        return username;
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void removeBook(Book book) {
        books.remove(book);
        saveBooks();
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

    private void saveBooks() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("books.ser"))) {
            out.writeObject(books);
        } catch (IOException e) {
            System.out.println("Failed to save books: " + e.getMessage());
        }
    }

    private void loadBooks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("books.ser"))) {
            books = (List<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved books found or failed to load books: " + e.getMessage());
        }
    }
}
