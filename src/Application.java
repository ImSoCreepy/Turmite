import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Application extends JFrame
{
    public static GridPanel centerPanel;

    private final Color bgColor = new Color(54,57,62);
    public Application()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Turmite simulation");
        this.setLayout(new BorderLayout());
        this.setSize(900,600);
        ImageIcon antIcon = new ImageIcon("src/img/ant.png"); //little ant icon for the frame
        this.setIconImage(antIcon.getImage());
        this.setLocationRelativeTo(null);

        centerPanel = new GridPanel(100,100);
        JScrollPane scrollPane = new JScrollPane(centerPanel);

        MenuPanel menuPanel = new MenuPanel();
        JScrollPane menuScrollPane = new JScrollPane(menuPanel);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(menuScrollPane, BorderLayout.EAST);
        this.setVisible(true);
    }
}
