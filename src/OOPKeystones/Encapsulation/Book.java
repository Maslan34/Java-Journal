package OOPKeystones.Encapsulation;

public class Book {
    private int pageNumber;
    private String bookName, author;
    Book(String bookName, int pageNumber, String yazar) {
        this.bookName = bookName;
        if (pageNumber < 1) {
            this.pageNumber = 10;
        } else {
            this.pageNumber = pageNumber;
        }
        this.author = yazar;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        if (pageNumber < 1) {
            this.pageNumber = 10;
        } else {
            this.pageNumber = pageNumber;
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
