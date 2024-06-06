import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("Moutawakkil");

        while (true) {
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()

            switch (option) {
                case 1:
                    displayBooks(user);
                    break;

                case 2:
                    addBook(user, scanner);
                    break;

                case 3:
                    removeBook(user, scanner);
                    break;

                case 4:
                    readBook(user, scanner);
                    break;

                case 5:
                    System.out.println("Merci d'avoir utilisé notre système de suivi de la lecture des livres. À la prochaine !");
                    return;

                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n1. Afficher les livres disponibles");
        System.out.println("2. Ajouter un livre");
        System.out.println("3. Supprimer un livre");
        System.out.println("4. Lire un livre");
        System.out.println("5. Quitter");
        System.out.print("Choisissez une option : ");
    }

    private static void displayBooks(User user) {
        System.out.println("\nLivres disponibles:");
        int number = 0;
        for (Book book : user.getBooks()) {
            number++;
            String status = book.getCurrentPage() == 0 ? "Vous n'avez pas encore commencé à lire ce livre" :
                    "Vous êtes arrêté à la page " + book.getCurrentPage();
            System.out.println(number + ". " + book.getTitle() + " - de " + book.getAuthor() + " - " + status);
        }
        pause();
    }

    private static void addBook(User user, Scanner scanner) {
        System.out.print("Titre du livre à ajouter: ");
        String title = scanner.nextLine();
        System.out.print("Auteur du livre : ");
        String author = scanner.nextLine();
        System.out.print("Nombre total de pages : ");
        int totalPages = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
        Book book = new Book(title, author, totalPages);
        user.addBook(book);
        System.out.println("Livre ajouté avec succès !");
    }

    private static void removeBook(User user, Scanner scanner) {
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
    }

    private static void readBook(User user, Scanner scanner) {
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
            if (bookToRead.getCurrentPage() == 0) {
                System.out.println("1. Commencer la lecture");
            } else {
                System.out.println("1. Relire le livre depuis le début");
                System.out.println("2. Reprendre depuis votre dernière lecture - page " + bookToRead.getCurrentPage());
            }
            System.out.print("Choisissez une option : ");
            int opt = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
            switch (opt) {
                case 1:
                    user.readBook(bookToRead, scanner);
                    break;
                case 2:
                    user.resumeReading(bookToRead, scanner);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        } else {
            System.out.println("Livre non trouvé.");
        }
    }

    private static void pause() {
        System.out.println("\nEst-ce que vous voulez continuer ?");
        System.out.println("1. Oui");
        System.out.println("2. Non");
        Scanner scanner = new Scanner(System.in);
        int decision = scanner.nextInt();
        scanner.nextLine();
        if (decision == 2) {
            System.out.println("Merci d'avoir utilisé notre système de suivi de la lecture des livres. À la prochaine !");
            System.exit(0);
        }
    }
}
