package Practices;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class BookSorter implements Comparable<BookSorter>{

    private String name;
    private String author;
    private int pageNumber;
    private int publishedYear;



    public BookSorter(String name, String author, int pageNumber, int publishedYear) {
        this.name = name;
        this.author = author;
        this.pageNumber = pageNumber;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                ", publishedYear=" + publishedYear +
                '}';
    }

    @Override
    public int compareTo(BookSorter o) {
        return this.getName().compareTo(o.getName());
    }


    public static void main(String[] args) {
        // Creating 5 different book objects
        BookSorter bookSorter1 = new BookSorter("1984", "George Orwell", 328, 1949);
        BookSorter bookSorter2 = new BookSorter("Les Misérables", "Victor Hugo", 1232, 1862);
        BookSorter bookSorter3 = new BookSorter("Crime and Punishment", "Fyodor Dostoevsky", 671, 1866);
        BookSorter bookSorter4 = new BookSorter("The Little Prince", "Antoine de Saint-Exupéry", 96, 1943);
        BookSorter bookSorter5 = new BookSorter("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 223, 1997);
        BookSorter bookSorter6 = new BookSorter("Harry Potter and the Sorcerer's Stones", "J.K. Rowling", 223, 1997);


        TreeSet<BookSorter> bookSorters = new TreeSet<BookSorter>();

        bookSorters.add(bookSorter1);
        bookSorters.add(bookSorter2);
        bookSorters.add(bookSorter3);
        bookSorters.add(bookSorter4);
        bookSorters.add(bookSorter5);
        bookSorters.add(bookSorter6);


        Iterator<BookSorter> comparator = bookSorters.iterator();
        System.out.println("Sorting Books by Name");
        while (comparator.hasNext()) {
            BookSorter bookSorter = comparator.next();
            System.out.println(bookSorter);
        }
        System.out.println("#####################");
        System.out.println("Sorting Books by Page Number");
        TreeSet<BookSorter> booksPageNumber = new TreeSet<BookSorter>(new Comparator<BookSorter>() {
            @Override
            public int compare(BookSorter o1, BookSorter o2) {
                return Integer.compare(o1.getPageNumber(), o2.getPageNumber());
            }
        });
        booksPageNumber.add(bookSorter1);
        booksPageNumber.add(bookSorter2);
        booksPageNumber.add(bookSorter3);
        booksPageNumber.add(bookSorter4);
        booksPageNumber.add(bookSorter5);
        booksPageNumber.add(bookSorter6);


        Iterator<BookSorter> comparatorPageNumber = booksPageNumber.iterator();
        while (comparatorPageNumber.hasNext()) {
            BookSorter bookSorter = comparatorPageNumber.next();
            System.out.println(bookSorter);
        }
    }
}
