package gui;

import com.sun.tools.javac.Main;
import controller.Controller;
import javafx.scene.control.Tab;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Toolbar extends JPanel {
    JButton _newButton;
    JButton openButton;
    JButton saveButton;
    JToolBar toolBar;
    FileChooser fileChooser;
    MainFrame mainFrame;


    public Toolbar() {
        toolBar = new JToolBar("Debug");
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createEtchedBorder());
        fileChooser = new FileChooser();

        //Load images
        ImageIcon _new = new ImageIcon("C:\\Users\\StefanNovak96\\IdeaProjects\\My Personal Library\\images\\new.png");
        ImageIcon open = new ImageIcon("C:\\Users\\StefanNovak96\\IdeaProjects\\My Personal Library\\images\\open.png");
        ImageIcon save = new ImageIcon("C:\\Users\\StefanNovak96\\IdeaProjects\\My Personal Library\\images\\save.png");

        //Create toolbar buttons
        _newButton = new JButton(_new);
        _newButton.setActionCommand("New");
        _newButton.setToolTipText("New");
        _newButton.setOpaque(false);
        _newButton.setContentAreaFilled(false);
        _newButton.setBorderPainted(false);

        openButton = new JButton(open);
        openButton.setActionCommand("Open");
        openButton.setToolTipText("Open");
        openButton.setOpaque(false);
        openButton.setContentAreaFilled(false);
        openButton.setBorderPainted(false);

        saveButton = new JButton(save);
        saveButton.setActionCommand("Save");
        saveButton.setToolTipText("Save");
        saveButton.setOpaque(false);
        saveButton.setContentAreaFilled(false);
        saveButton.setBorderPainted(false);

        add(_newButton);
        add(openButton);
        add(saveButton);

//        //toolbar listeners
//        openButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainFrame.open();
//            }
//        });
    }


}
