package gui;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    JButton _newButton;
    JButton openButton;
    JButton saveButton;
    JToolBar toolBar;
    FileChooser fileChooser;

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
    }
}
