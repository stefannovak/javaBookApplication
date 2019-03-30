package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Database {

    private List<Book> books;

    public Database() {
        books = new LinkedList<Book>();
    }

    public void addBook (Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        books.remove(index);
        //ID FIX: maybe something like for(row index number; for all rows > than this number; reduce all IDs by 1)
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
