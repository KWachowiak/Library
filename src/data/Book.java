package data;

import java.io.Serializable;

public class Book extends Publication implements Serializable{
    private static final long serialVersionUID = -7907331751072277846L;

    private String author;
    private int pages;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(int year, String title, String publisher, String author, int pages, String isbn) {
        super(year, title, publisher);
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getPages() != book.getPages()) return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        return getIsbn() != null ? getIsbn().equals(book.getIsbn()) : book.getIsbn() == null;
    }

    @Override
    public int hashCode() {
        int result = getAuthor() != null ? getAuthor().hashCode() : 0;
        result = 31 * result + getPages();
        result = 31 * result + (getIsbn() != null ? getIsbn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(getAuthor());
        print.append("; ");
        print.append(getTitle());
        print.append("; ");
        print.append(getYear());
        print.append("; ");
        print.append(getPages());
        print.append("; ISBN: ");
        print.append(getIsbn());
        return print.toString();
    }
}
