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
        } else {
            System.out.println("You have reached the end of the book.");
        }
    }

    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
        } else {
            System.out.println("You are already at the beginning of the book.");
        }
    }
}


