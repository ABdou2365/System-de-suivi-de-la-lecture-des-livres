public class Book {
    private String title;
    private String author;
    private int totalPages;
    private int currentPage;

    public Book(String title, String author, int totalPages) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.currentPage = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage >= 0 && currentPage <= totalPages) {
            this.currentPage = currentPage;
        } else {
            System.out.println("Invalid page number.");
        }
    }

    public void nextPage() {
        if (currentPage < totalPages) {
            currentPage++;
            System.out.println("Page " + currentPage + " sur " + totalPages);
        } else {
            System.out.println("Vous avez atteint la fin du livre.");
        }
    }

    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            System.out.println("Page " + currentPage + " sur " + totalPages);
        } else {
            System.out.println("Vous êtes déjà au début du livre.");
        }
    }
}


