package gui;

import com.sun.tools.javac.Main;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    private BookPanel bookPanel;
    private TablePanel tablePanel;
    private Toolbar toolbar;
    private Controller controller;
    private JFileChooser fileChooser;
    private JPopupMenu jPopupMenu;

    public MainFrame() {
        //General settings
        super("Book Application");
        setMinimumSize(new Dimension(600,400));
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        //specific for open/save
        controller = new Controller();
        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new BookFileFilter());

        //LEFT
        bookPanel = new BookPanel();
        add(bookPanel, BorderLayout.WEST);

        //RIGHT
        tablePanel = new TablePanel();
        add(tablePanel, BorderLayout.CENTER);
        tablePanel.setData(controller.getBook());

        //TOP
        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);

        ///////////////// Menus ///////////////////////
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //File
        JMenu file = new JMenu("File");
        JMenuItem fileNew = new JMenuItem("New");
        JMenuItem fileOpen = new JMenuItem("Open");
        JMenuItem fileSave = new JMenuItem("Save");
        JSeparator fileSeperator = new JSeparator();
        JMenuItem fileExit = new JMenuItem("Exit");
        file.add(fileNew);
        file.add(fileOpen);
        file.add(fileSave);
        file.add(fileSeperator);
        file.add(fileExit);
        menuBar.add(file);

        //Contact
        JMenu contact = new JMenu("Contact");
        JMenuItem contactAbout = new JMenuItem("About...");
        contact.add(contactAbout);
        menuBar.add(contact);
        JLabel about = new JLabel("Hello and thank you for" +
                " taking the time to play with my app! This is my first ever app that I created in Java " +
                "and it was a really enjoyable experience. I know it's extremely vanilla looking, and lacks " +
                "a few features, but I won't be giving up on this app and will be routinely updating it with " +
                "more and more features. This was really an app I created for myself to test myself and to actually " +
                "keep track of the many many books I have purchased over the years. If you have any enquiries " +
                "please don't hesitate to contact me at my GitHub profile or LinkedIn!\n" +
                "https://github.com/stefannovak\nhttps://www.linkedin.com/in/stefan-novak-110ab1114/");

        //File Mnemonics
        file.setMnemonic(KeyEvent.VK_F);
        fileNew.setMnemonic(KeyEvent.VK_N);
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileExit.setMnemonic(KeyEvent.VK_X);

        //Contact Mnemonics
        contact.setMnemonic(KeyEvent.VK_C);
        contactAbout.setMnemonic(KeyEvent.VK_A);

        //File shortcuts
        fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));

        //Contact shortcuts
        contactAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));

        //POPUP MENU
        jPopupMenu = new JPopupMenu();
        JMenuItem jpuNew = new JMenuItem("New");
        JSeparator jpuSeperator = new JSeparator();
        JMenuItem jpuExit = new JMenuItem("Exit");
        jPopupMenu.add(jpuNew);
        jPopupMenu.add(jpuSeperator);
        jPopupMenu.add(jpuExit);

        //BUNCH OF LISTENERS
        //MENUS
        fileNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTable();
            }
        });

        fileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });

        fileSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        //CONTACT MENUS
        contactAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this,
                        "<html><body><p style='width: 300px;'>"+about.getText());
            }
        });

        //POPUP MENU
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.isPopupTrigger()) {
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()) {
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        jpuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTable();
            }
        });

        jpuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        //BOOK PANEL ADDER
        bookPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent e) {
                controller.addPerson(e);
                tablePanel.refresh();
            }
        });

        //TABLE DELETER
        tablePanel.setBookTableListener(new BookTableListener() {
            public void rowDeleted(int row) {
                controller.removeBook(row);
            }
        });

        //TOOLBARS
        toolbar.openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });

        toolbar.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        toolbar._newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTable();
            }
        });
    }

    //A few methods

    public void newTable() {
        if (JOptionPane.showConfirmDialog(MainFrame.this,
                "Are you sure you want to create a new file?",
                "Confirm", JOptionPane.OK_CANCEL_OPTION) == JFileChooser.APPROVE_OPTION) {
            //Create and set up the content pane. it's kind of cheap - should be improved. 30/03/19
            setVisible(false);
            MainFrame newFrame = new MainFrame();
        }
    }

    public void save() {
        if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
            try {
                controller.saveToFile(fileChooser.getSelectedFile());
            } catch(IOException el){
                JOptionPane.showMessageDialog(MainFrame.this,
                        "Could not save data to file",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void open() {
        if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
            try {
                controller.loadFromFile(fileChooser.getSelectedFile());
                tablePanel.refresh();
            } catch(IOException el){
                JOptionPane.showMessageDialog(MainFrame.this,
                        "Could not load data from file",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void exit() {
        if (JOptionPane.showConfirmDialog(MainFrame.this,
                "Are you sure you want to exit?",
                "Exit", JOptionPane.OK_CANCEL_OPTION) == JFileChooser.APPROVE_OPTION) {
            //exit
            System.exit(0);
        }
    }

}