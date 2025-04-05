package Practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookList {

    private String name;
    private int numberOfPages;
    private String author;


    public BookList(String name, int numberOfPages, String author) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void printBookInfo() {
        System.out.println("Book Name: " + name);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Author: " + author);
        System.out.println("----------------------");
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {

        BookList bookList1 = new BookList("1984", 328, "George Orwell");
        BookList bookList2 = new BookList("Brave New World", 311, "Aldous Huxley");
        BookList bookList3 = new BookList("To Kill a Mockingbird", 281, "Harper Lee");
        BookList bookList4 = new BookList("The Great Gatsby", 180, "F. Scott Fitzgerald");
        BookList bookList5 = new BookList("Moby Dick", 635, "Herman Melville");
        BookList bookList6 = new BookList("War and Peace", 1225, "Leo Tolstoy");
        BookList bookList7 = new BookList("Crime and Punishment", 671, "Fyodor Dostoevsky");
        BookList bookList8 = new BookList("The Catcher in the Rye", 277, "J.D. Salinger");
        BookList bookList9 = new BookList("Pride and Prejudice", 432, "Jane Austen");
        BookList bookList10 = new BookList("The Hobbit", 310, "J.R.R. Tolkien");

        ArrayList<BookList> arr = new ArrayList<BookList>();
        arr.add(bookList1);
        arr.add(bookList2);
        arr.add(bookList3);
        arr.add(bookList4);
        arr.add(bookList5);
        arr.add(bookList6);
        arr.add(bookList7);
        arr.add(bookList8);
        arr.add(bookList9);
        arr.add(bookList10);

       // arr.stream().forEach(Book::printBookInfo);


        Map<String, String> map = arr.stream()
                .collect(Collectors.toMap(bookList -> bookList.getName(), bookList -> bookList.getAuthor()));


        map.forEach((bookName, author) -> System.out.println("Book Name: " + bookName + ", Author: " + author));

        System.out.println("\n###### Boooks which is page number bigger than 100 ######\n");

        List<BookList> bookLists = arr.stream().filter(bookList -> bookList.numberOfPages>100)
                .collect(Collectors.toList());

        bookLists.forEach(System.out::println);

    }
}
