import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private JTable table;

    public TablePanel() {

        table = new JTable();

        setLayout(new BorderLayout());

        add(table, BorderLayout.CENTER);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
