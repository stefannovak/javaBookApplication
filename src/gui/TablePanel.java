package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import model.Book;
import java.io.*;

public class TablePanel extends JPanel {
    private JTable table;
    private BookTableModel model;

    public TablePanel() {
        model = new BookTableModel();

        table = new JTable(model);

        setLayout(new BorderLayout());

        add(table, BorderLayout.CENTER);

        add(new JScrollPane(table), BorderLayout.CENTER);

        //table.setAutoCreateRowSorter(true);
        //table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void setData(List<Book> db) {
        model.setData(db);
    }

    public void refresh() {
        model.fireTableDataChanged();
    }
}
