package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private ArrayList<Book> books;

    public Database() {
        books = new ArrayList<Book>();
    }

    public void addBook (Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    //Saving
    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Book[] bookArray = books.toArray(new Book[books.size()]);

        oos.writeObject(bookArray);

        oos.close();
    }

    //Loading
    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Book[] bookArray = (Book[])ois.readObject();

            books.clear();

            books.addAll(Arrays.asList(bookArray));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}
