package gui;

import model.Genre;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookPanel extends JPanel {

    private JLabel bookTitle;
    private JTextField bookTitleField;
    private JLabel author;
    private JTextField authorField;
    private JLabel genre;
    private JComboBox genreBox;
    private JLabel location;
    private JTextField locationField;
    private JButton okButton;
    private JLabel special;
    private JCheckBox specialCheck;
    private JTextField specialField;
    private FormListener formListener;
    private JButton resetButton;

    public BookPanel() {
        bookTitle = new JLabel("Title: ");
        bookTitleField = new JTextField(10);
        author = new JLabel("Author: ");
        authorField = new JTextField(10);
        genre = new JLabel("Genre: ");
        genreBox = new JComboBox();
        location = new JLabel("Location: ");
        locationField = new JTextField(10);
        special = new JLabel("Special? ");
        specialCheck = new JCheckBox();
        specialField = new JTextField(10);
        okButton = new JButton("Add");
        resetButton = new JButton("Reset");

        DefaultComboBoxModel genreModel = new DefaultComboBoxModel();
        genreModel.addElement(new Genre(0, ""));
        genreModel.addElement(new Genre(1, "Classic"));
        genreModel.addElement(new Genre(2, "Non-Fiction"));
        genreModel.addElement(new Genre(3, "Fantasy"));
        genreModel.addElement(new Genre(4, "Sci-Fi"));
        genreModel.addElement(new Genre(5, "Short Story"));
        genreModel.addElement(new Genre(6, "Thriller"));
        genreModel.addElement(new Genre(7, "Western"));
        genreModel.addElement(new Genre(8, "Biography"));
        genreModel.addElement(new Genre(9, "Autobiography"));
        genreModel.addElement(new Genre(10, "Textbook"));
        genreModel.addElement(new Genre(11, "Detective"));
        genreModel.addElement(new Genre(12, "Crime"));
        genreModel.addElement(new Genre(13, "Self-Help"));
        genreModel.addElement(new Genre(14, "Graphic Novel"));
        genreModel.addElement(new Genre(15, "Other..."));
        genreBox.setModel(genreModel);

        //Special Fields
        specialField.setEnabled(false);
        ////////TO BE MOVED
        specialCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialField.setEnabled(true);
            }
        });

        //okButton event
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleEv = bookTitleField.getText();
                String authorEv = authorField.getText();
                Genre genreEv = (Genre)genreBox.getSelectedItem();
                String locationEv = locationField.getText();
                String specialEv = specialField.getText();

                FormEvent ev = new FormEvent(this, titleEv, authorEv, genreEv, locationEv, specialEv);

                if(formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        });

        //resetButton event
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTitleField.setText("");
                authorField.setText("");
                genreModel.setSelectedItem(genreModel.getElementAt(0));
                locationField.setText("");
                specialCheck.setSelected(false);
                specialField.setEnabled(false);
                specialField.setText("");
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add New Book");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        layoutComponents();

    }

    public void layoutComponents() {
        /////////////// GRID LAYOUT ////////////////////////
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //////////////// FIRST ROW ////////////////////////
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(bookTitle, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(bookTitleField, gc);

        //////////////// SECOND ROW ////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(author, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(authorField, gc);

        //////////////// THIRD ROW ////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(genre, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(genreBox, gc);

        //////////////// FOURTH ROW ////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(location, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(locationField, gc);

        //////////////// FIFTH ROW ////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(special, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(specialCheck, gc);

        //////////////// SIXTH ROW ////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 1;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(specialField, gc);

        //////////////// LAST ROW ////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 0;

        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(resetButton, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
