import javax.swing.*;
import java.awt.*;

public class Application
{
    private final Color bgColor = new Color(54,57,62);
    public Application()
    {
        JFrame frame = new JFrame("Turmite simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        ImageIcon antIcon = new ImageIcon("src/img/ant.png"); //little ant icon for the frame
        frame.setIconImage(antIcon.getImage());
        frame.getContentPane().setBackground(bgColor);
        frame.setLocationRelativeTo(null);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(bgColor);
        leftPanel.setOpaque(true);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(bgColor);
        rightPanel.setOpaque(true);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel);
        splitPane.setDividerLocation(600);
        splitPane.setOneTouchExpandable(true);

        frame.add(splitPane);
        frame.setVisible(true);
    }
}
