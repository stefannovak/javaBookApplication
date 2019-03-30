package controller;

import gui.FormEvent;
import model.Book;
import model.Database;
import model.Genre;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Book> getBook() {
        return db.getBooks();
    }

    public void addPerson(FormEvent ev){
        String title = ev.getTitle();
        String author = ev.getAuthor();
        Genre genre = ev.getGenre();
        String location = ev.getLocation();
        String special = ev.getSpecialNote();

        Book book = new Book(title, author, genre, location, special);
        db.addBook(book);

        //ID FIX: Maybe a for loop to see if the ID above it isnt in order with the ID about to be instantiated??
    }

    public void removeBook(int index) {
        db.removeBook(index);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
