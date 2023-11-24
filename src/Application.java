import javax.swing.*;
import java.awt.*;

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

        JPanel menuPanel = initMenuPanel();


        this.add(scrollPane, BorderLayout.CENTER);
        this.add(menuPanel, BorderLayout.EAST);
        this.setVisible(true);
    }

    private JPanel initMenuPanel()
    {
        JPanel tmpMenuPanel = new JPanel();
        tmpMenuPanel.setLayout(new GridLayout(20,1));
        //tmpMenuPanel.setLayout(new BoxLayout(tmpMenuPanel, BoxLayout.Y_AXIS));

        JLabel r1 = new JLabel("Rule 1:");
        JTextField rule1 = new JTextField(9);
        rule1.setText("0-0-R-1-0");

        JLabel r2 = new JLabel("Rule 2:");
        JTextField rule2 = new JTextField(9);
        rule2.setText("0-1-R-1-1");

        JLabel r3 = new JLabel("Rule 3:");
        JTextField rule3 = new JTextField(9);
        rule3.setText("1-0-N-0-0");

        JLabel r4 = new JLabel("Rule 4:");
        JTextField rule4 = new JTextField(9);
        rule4.setText("1-1-N-0-1");

        tmpMenuPanel.add(r1);
        tmpMenuPanel.add(rule1);
        tmpMenuPanel.add(r2);
        tmpMenuPanel.add(rule2);
        tmpMenuPanel.add(r3);
        tmpMenuPanel.add(rule3);
        tmpMenuPanel.add(r4);
        tmpMenuPanel.add(rule4);

        JButton startButton = new JButton("Start simulation");
        startButton.setFocusable(false);
        startButton.addActionListener(e -> {
            if(startButton.getText().equals("Start simulation"))
            {
                centerPanel.turmite.initRules(rule1.getText(), rule2.getText(), rule3.getText(), rule4.getText());

                startButton.setText("Stop simulation");
                centerPanel.isRunning = true;
            }
            else
            {
                startButton.setText("Start simulation");
                centerPanel.isRunning = false;
            }
        });

        JButton saveButton = new JButton("Save configuration");
        saveButton.setFocusable(false);
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showDialog(this, "Select");
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                System.out.println(fileChooser.getSelectedFile().getName());
            }
        });

        JButton loadButton = new JButton("Load configuration");
        loadButton.setFocusable(false);
        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showDialog(this, "Select");
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                System.out.println(fileChooser.getSelectedFile().getName());
            }
        });

        JButton resetButton = new JButton("Reset simulation");
        resetButton.setFocusable(false);
        resetButton.addActionListener(e -> {
            centerPanel.resetSim();
            startButton.setText("Start simulation");
        });

        tmpMenuPanel.add(startButton);
        tmpMenuPanel.add(saveButton);
        tmpMenuPanel.add(loadButton);
        tmpMenuPanel.add(resetButton);

        return tmpMenuPanel;
    }
}
