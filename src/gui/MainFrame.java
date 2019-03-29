package gui;

import model.Genre;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {

    private BookPanel bookPanel;
    private TablePanel tablePanel;
    private Toolbar toolbar;
    private BookTableModel bookTableModel;
    private Controller controller;
    private JFileChooser fileChooser;

    public MainFrame() {
        //General settings
        super("Book Application");
        setMinimumSize(new Dimension(500,400));
        setSize(600,500);
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
        //BorderFactory.createEtchedBorder();

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

        //File Mnemonics
        file.setMnemonic(KeyEvent.VK_F);
        fileNew.setMnemonic(KeyEvent.VK_N);
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileExit.setMnemonic(KeyEvent.VK_X);

        //File shortcuts
        fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));

        //BUNCH OF LISTENERS
        fileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
//                    try {
//                        controller.loadFromFile(fileChooser.getSelectedFile());
//                        tablePanel.refresh();
//                    } catch(IOException el){
//                        JOptionPane.showMessageDialog(MainFrame.this,
//                                "Could not load data from file",
//                                "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
                open();
            }
        });

        fileSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
//                    try {
//                        controller.saveToFile(fileChooser.getSelectedFile());
//                    } catch(IOException el){
//                    JOptionPane.showMessageDialog(MainFrame.this,
//                            "Could not save data to file",
//                            "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
                save();
            }
        });

        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        bookPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent e) {
                controller.addPerson(e);
                tablePanel.refresh();
            }
        });

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
    }

    public void newTable() {
        //To be figured out
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

}