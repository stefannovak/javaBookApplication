package gui;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import model.Book;

/////////////// SORTING KILLS MY APP - TO BE IMPLEMENTED - 30/03/19 /////////////////////////

public class TablePanel extends JPanel {
    private JTable table;
    private BookTableModel model;
    //private TableRowSorter<BookTableModel> sorter;
    private JPopupMenu jPopupMenu;
    private BookTableListener bookTableListener;

    public TablePanel() {
        //General
        model = new BookTableModel();
        table = new JTable(model);
        setLayout(new BorderLayout());

        //Popup menu for the table
        jPopupMenu = new JPopupMenu();
        JMenuItem removeItem = new JMenuItem("Delete Row");
        jPopupMenu.add(removeItem);

        //add to frame
        add(table, BorderLayout.CENTER);
        add(new JScrollPane(table), BorderLayout.CENTER);

        //popup listener
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);

                if(e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(table, e.getX(), e.getY());
                }
            }
        });

        //remove listener
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(bookTableListener != null) {
                    bookTableListener.rowDeleted(row);
                    model.fireTableRowsDeleted(row, row);
                }
            }
        });
    }

    public void setData(List<Book> db) {
        model.setData(db);
    }

    public void refresh() {
        model.fireTableDataChanged();
    }

    public void setBookTableListener(BookTableListener listener) {
        this.bookTableListener = listener;
    }
}
