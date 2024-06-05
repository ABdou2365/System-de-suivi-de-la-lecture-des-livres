import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("Abdellah"); // Créer un utilisateur avec un nom donné
        Book book1 = new Book("l'ile au trésor","Robert Louis Stevenson",207);
        Book book2 = new Book("la boîte a merveilles","ahmed SEFRIOUI",249);
        Book book3 = new Book("Antigone","Jean Anouilh",128);


        user.addBook(book1);
        user.addBook(book2);
        user.addBook(book3);


        while (true) {
            System.out.println("0. afficher les livres disponible");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Lire un livre");
            System.out.println("4. Arrêter la lecture");
            System.out.println("5. Reprendre la lecture");
            System.out.println("6. Quitter");

            System.out.print("Choisissez une option : ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()

            switch (option) {
                case 0:
                    for (Book book : user.getBooks()) {
                        System.out.println(book.getTitle());
                    }
                    try{
                        Thread.sleep(4000);
                        System.out.println("");
                        System.out.println("");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("Est ce que vous voulez continuer ?");
                    System.out.println("1. Oui");
                    System.out.println("2. Non");

                    int decision = scanner.nextInt();
                    scanner.nextLine();
                    switch (decision) {
                        case 1:
                            break;
                        case 2:
                            System.out.println("Merci d'avoir utilisé notre système de suivi de la lecture des livres !");
                            return;
                    }
                    break;

                case 1:
                    System.out.print("Titre du livre vous ajouterez: ");
                    String title = scanner.nextLine();
                    System.out.print("Auteur du livre : ");
                    String author = scanner.nextLine();
                    System.out.print("Nombre total de pages : ");
                    int totalPages = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
                    Book book = new Book(title, author, totalPages);
                    user.addBook(book);
                    System.out.println("Livre ajouté avec succès !");
                    break;
                case 2:
                    System.out.print("Titre du livre à supprimer : ");
                    String bookTitle = scanner.nextLine();
                    Book bookToRemove = null;
                    for (Book b : user.getBooks()) {
                        if (b.getTitle().equals(bookTitle)) {
                            bookToRemove = b;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        user.removeBook(bookToRemove);
                        System.out.println("Livre supprimé avec succès !");
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Titre du livre à lire : ");
                    String bookTitleToRead = scanner.nextLine();
                    Book bookToRead = null;
                    for (Book b : user.getBooks()) {
                        if (b.getTitle().equals(bookTitleToRead)) {
                            bookToRead = b;
                            break;
                        }
                    }
                    if (bookToRead != null) {
                        user.readBook(bookToRead);
                        System.out.println("Lecture commencée.");
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 4:
                    System.out.print("Titre du livre à arrêter : ");
                    String bookTitleToStop = scanner.nextLine();
                    Book bookToStop = null;
                    for (Book b : user.getBooks()) {
                        if (b.getTitle().equals(bookTitleToStop)) {
                            bookToStop = b;
                            break;
                        }
                    }
                    if (bookToStop != null) {
                        user.stopReading(bookToStop);
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 5:
                    System.out.print("Titre du livre à reprendre : ");
                    String bookTitleToResume = scanner.nextLine();
                    Book bookToResume = null;
                    for (Book b : user.getBooks()) {
                        if (b.getTitle().equals(bookTitleToResume)) {
                            bookToResume = b;
                            break;
                        }
                    }
                    if (bookToResume != null) {
                        user.resumeReading(bookToResume);
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 6:
                    System.out.println("Merci d'avoir utilisé notre système de suivi de la lecture des livres !");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        }
    }
}
