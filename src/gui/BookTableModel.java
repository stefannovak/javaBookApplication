package gui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Book;

public class BookTableModel extends AbstractTableModel {
    private List<Book> db;

    public BookTableModel() {
    }

    public void setData(List<Book> db) {
        this.db = db;
    }

    public String[] columnNames = {"ID", "Title", "Author", "Genre", "Location", "Notes"};

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Book book = db.get(row);

        switch (col) {
            case 0:
                return book.getId();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthor();
            case 3:
                return book.getGenre();
            case 4:
                return book.getLocation();
            case 5:
                return book.getSpecialNote();
        }

        return null;
    }

    public void setValueAt(Object value, int row, int col) {
        //rowData[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
