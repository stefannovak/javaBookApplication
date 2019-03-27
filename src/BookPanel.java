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

    public BookPanel() {
        bookTitle = new JLabel("Title: ");
        bookTitleField = new JTextField(10);
        author = new JLabel("Author: ");
        authorField = new JTextField(10);
        genre = new JLabel("Genre: ");
        genreBox = new JComboBox();
        location = new JLabel("Location: ");
        locationField = new JTextField(10);
        okButton = new JButton("Add");
        special = new JLabel("Special? ");
        specialCheck = new JCheckBox();
        specialField = new JTextField(10);

        //Genre Field
        String[] genreTypes = {"Classic", "Graphic Novel", "Crime", "Crime/Detective", "Fantasy", "Sci-Fi", "Short Story",
                                "Thriller", "Western", "Biography", "Autobiography", "Textbook", "Self-Help"};
        genreBox = new JComboBox(genreTypes);
        add(genreBox);

        //Special Fields
        specialField.setEnabled(false);
        ////////TO BE MOVED
        specialCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialField.setEnabled(true);
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add New Book");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        Dimension dim = getPreferredSize();
        dim.width = 350;
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
        gc.gridy = 5;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 1;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(specialField, gc);

        //////////////// LAST ROW ////////////////////////
        gc.gridy = 6;

        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 1;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(okButton, gc);
    }

//    class GenreCategory {
//        private int id;
//        private String text;
//
//        public GenreCategory(int id, String text) {
//            this.id = id;
//            this.text = text;
//        }
//    }
}
