package gui;

import model.Genre;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String title;
    private String author;
    private Genre genre;
    private String location;
    private String specialNote;


    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String title, String author, Genre genre,
                     String location, String specialNote)
    {
        super(source);

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.location = location;
        this.specialNote = specialNote;
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

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }
}
