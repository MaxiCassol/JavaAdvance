package LibraryManagement;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private boolean available;
    private boolean damaged;

    public Book(String title, String author, String isbn, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.available = true;
        this.damaged = false;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public boolean isAvailable() {
        return available;
    }
}