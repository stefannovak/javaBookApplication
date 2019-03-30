package model;

import java.io.Serializable;

// Count needs a major fix. Find a way to auto adjust all book IDs when table is changed.
// Includes deletion, saving, opening and new file. 30/03/19
// its something to do with table model

public class Book implements Serializable {
    private static int count = 0;
    private int id;
    private String title;
    private String author;
    private Genre genre;
    private String location;
    private boolean isSpecial;
    private String specialNote;

    public Book(String title, String author, Genre genre, String location, String specialNote) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.location = location;
        this.specialNote = specialNote;

        this.id = count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }


}
