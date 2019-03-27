import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private BookPanel bookPanel;
    private TablePanel tablePanel;

    public MainFrame() {
        super("Book Application");
        setMinimumSize(new Dimension(500,400));
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        //LEFT
        bookPanel = new BookPanel();
        add(bookPanel, BorderLayout.WEST);
        BorderFactory.createEtchedBorder();

        //RIGHT
        tablePanel = new TablePanel();
        add(tablePanel, BorderLayout.EAST);
        BorderFactory.createEtchedBorder();

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

        //File Mnemomics
        file.setMnemonic(KeyEvent.VK_F);
        fileNew.setMnemonic(KeyEvent.VK_N);
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileExit.setMnemonic(KeyEvent.VK_X);

        //File shortcuts
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));

        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}