import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel
{
    private JComboBox<Integer> rule1State;
    private JComboBox<Integer> rule1CellValue;
    private JComboBox<String> rule1Direction;
    private JComboBox<Integer> rule1NewCellValue;
    private JComboBox<Integer> rule1NewState;

    private JComboBox<Integer> rule2State;
    private JComboBox<Integer> rule2CellValue;
    private JComboBox<String> rule2Direction;
    private JComboBox<Integer> rule2NewCellValue;
    private JComboBox<Integer> rule2NewState;

    private JComboBox<Integer> rule3State;
    private JComboBox<Integer> rule3CellValue;
    private JComboBox<String> rule3Direction;
    private JComboBox<Integer> rule3NewCellValue;
    private JComboBox<Integer> rule3NewState;
    private JCheckBox rule3Disable;

    private JComboBox<Integer> rule4State;
    private JComboBox<Integer> rule4CellValue;
    private JComboBox<String> rule4Direction;
    private JComboBox<Integer> rule4NewCellValue;
    private JComboBox<Integer> rule4NewState;
    private JCheckBox rule4Disable;

    public MenuPanel()
    {
        //this.setPreferredSize(new Dimension(200,600));
        //this.setLayout(new GridLayout(20,1));
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);

        gridBagConstraints.insets = new Insets(5,0,0,0);

        //Rule 1 attributes
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        JLabel r1 = new JLabel("Rule 1:");
        this.add(r1, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        rule1State = new JComboBox<>(new Integer[]{0, 1});
        rule1State.addActionListener(changeListener);
        this.add(rule1State,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        rule1CellValue = new JComboBox<>(new Integer[]{0, 1});
        rule1CellValue.addActionListener(changeListener);
        this.add(rule1CellValue, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        rule1Direction = new JComboBox<>(new String[]{"Right","Left","Noturn","U-turn"});
        rule1Direction.addActionListener(changeListener);
        this.add(rule1Direction, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        rule1NewCellValue = new JComboBox<>(new Integer[]{0, 1});
        rule1NewCellValue.addActionListener(changeListener);
        this.add(rule1NewCellValue, gridBagConstraints);

        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        rule1NewState = new JComboBox<>(new Integer[]{0, 1});
        rule1NewState.addActionListener(changeListener);
        this.add(rule1NewState,gridBagConstraints);


        //Rule 2 attributes
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        JLabel r2 = new JLabel("Rule 2:");
        this.add(r2, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        rule2State = new JComboBox<>(new Integer[]{0, 1});
        rule2State.addActionListener(changeListener);
        this.add(rule2State,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        rule2CellValue = new JComboBox<>(new Integer[]{0, 1});
        rule2CellValue.addActionListener(changeListener);
        this.add(rule2CellValue, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        rule2Direction = new JComboBox<>(new String[]{"Right","Left","Noturn","U-turn"});
        rule2Direction.addActionListener(changeListener);
        this.add(rule2Direction, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        rule2NewCellValue = new JComboBox<>(new Integer[]{0, 1});
        rule2NewCellValue.addActionListener(changeListener);
        this.add(rule2NewCellValue, gridBagConstraints);

        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        rule2NewState = new JComboBox<>(new Integer[]{0, 1});
        rule2NewState.addActionListener(changeListener);
        this.add(rule2NewState,gridBagConstraints);


        //Rule 3 attributes
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        JLabel r3 = new JLabel("Rule 3:");
        this.add(r3, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        rule3State = new JComboBox<>(new Integer[]{0, 1});
        rule3State.addActionListener(changeListener);
        this.add(rule3State,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        rule3CellValue = new JComboBox<>(new Integer[]{0, 1});
        rule3CellValue.addActionListener(changeListener);
        this.add(rule3CellValue, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        rule3Direction = new JComboBox<>(new String[]{"Right","Left","Noturn","U-turn"});
        rule3Direction.addActionListener(changeListener);
        this.add(rule3Direction, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        rule3NewCellValue = new JComboBox<>(new Integer[]{0, 1});
        rule3NewCellValue.addActionListener(changeListener);
        this.add(rule3NewCellValue, gridBagConstraints);

        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        rule3NewState = new JComboBox<>(new Integer[]{0, 1});
        rule3NewState.addActionListener(changeListener);
        this.add(rule3NewState,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        rule3Disable = new JCheckBox("Disable");
        rule3Disable.addItemListener(e -> {
            if(rule3Disable.isSelected())
            {
                rule3State.setEnabled(false);
                rule3CellValue.setEnabled(false);
                rule3Direction.setEnabled(false);
                rule3NewCellValue.setEnabled(false);
                rule3NewState.setEnabled(false);
            }
            else
            {
                rule3State.setEnabled(true);
                rule3CellValue.setEnabled(true);
                rule3Direction.setEnabled(true);
                rule3NewCellValue.setEnabled(true);
                rule3NewState.setEnabled(true);
            }
            Application.centerPanel.turmite.initRules(readRules());
        });
        this.add(rule3Disable, gridBagConstraints);


        //Rule 4 attributes
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        JLabel r4 = new JLabel("Rule 4:");
        this.add(r4, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        rule4State = new JComboBox<>(new Integer[]{0, 1});
        rule4State.addActionListener(changeListener);
        this.add(rule4State,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        rule4CellValue = new JComboBox<>(new Integer[]{0, 1});
        rule4CellValue.addActionListener(changeListener);
        this.add(rule4CellValue, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        rule4Direction = new JComboBox<>(new String[]{"Right","Left","Noturn","U-turn"});
        rule4Direction.addActionListener(changeListener);
        this.add(rule4Direction, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        rule4NewCellValue = new JComboBox<>(new Integer[]{0, 1});
        rule4NewCellValue.addActionListener(changeListener);
        this.add(rule4NewCellValue, gridBagConstraints);

        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        rule4NewState = new JComboBox<>(new Integer[]{0, 1});
        rule4NewState.addActionListener(changeListener);
        this.add(rule4NewState,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        rule4Disable = new JCheckBox("Disable");
        rule4Disable.addItemListener(e -> {
            if(rule4Disable.isSelected())
            {
                rule4State.setEnabled(false);
                rule4CellValue.setEnabled(false);
                rule4Direction.setEnabled(false);
                rule4NewCellValue.setEnabled(false);
                rule4NewState.setEnabled(false);
            }
            else
            {
                rule4State.setEnabled(true);
                rule4CellValue.setEnabled(true);
                rule4Direction.setEnabled(true);
                rule4NewCellValue.setEnabled(true);
                rule4NewState.setEnabled(true);
            }
            Application.centerPanel.turmite.initRules(readRules());
        });
        this.add(rule4Disable, gridBagConstraints);


        gridBagConstraints.insets = new Insets(15,0,0,0);

        //StartButton init
        JButton startButton = new JButton("Start simulation");
        startButton.setFocusable(false);
        startButton.addActionListener(e -> {
            if(startButton.getText().equals("Start simulation"))
            {
                Application.centerPanel.turmite.initRules(readRules());

                startButton.setText("Stop simulation");
                Application.centerPanel.isRunning = true;
            }
            else
            {
                startButton.setText("Start simulation");
                Application.centerPanel.isRunning = false;
            }
        });
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        this.add(startButton,gridBagConstraints);


        //SaveButton init
        JButton saveButton = new JButton("Save configuration");
        saveButton.setFocusable(false);
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showDialog(this, "Select");
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                saveSettings(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        this.add(saveButton,gridBagConstraints);


        //LoadButton init
        JButton loadButton = new JButton("Load configuration");
        loadButton.setFocusable(false);
        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showDialog(this, "Select");
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                loadSettings(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        this.add(loadButton,gridBagConstraints);


        //ResetButton init
        JButton resetButton = new JButton("Reset simulation");
        resetButton.setFocusable(false);
        resetButton.addActionListener(e -> {
            Application.centerPanel.resetSim();
            startButton.setText("Start simulation");
        });
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        this.add(resetButton,gridBagConstraints);

        Application.centerPanel.turmite.initRules(readRules());
    }

    private ArrayList<Rule> readRules()
    {
        ArrayList<Rule> rules = new ArrayList<>();

        String firstChar = ((String) rule1Direction.getSelectedItem()).substring(0,1);
        Rule rule1 = new Rule((Integer) rule1State.getSelectedItem(), (Integer) rule1CellValue.getSelectedItem(), Rule.returnDirection(firstChar), (Integer)rule1NewCellValue.getSelectedItem(), (Integer)rule1NewState.getSelectedItem());
        rules.add(rule1);

        firstChar = ((String) rule2Direction.getSelectedItem()).substring(0,1);
        Rule rule2 = new Rule((Integer) rule2State.getSelectedItem(), (Integer) rule2CellValue.getSelectedItem(), Rule.returnDirection(firstChar), (Integer)rule2NewCellValue.getSelectedItem(), (Integer)rule2NewState.getSelectedItem());
        rules.add(rule2);

        isRuleSelected(rules, rule3Disable, rule3Direction, rule3State, rule3CellValue, rule3NewCellValue, rule3NewState);

        isRuleSelected(rules, rule4Disable, rule4Direction, rule4State, rule4CellValue, rule4NewCellValue, rule4NewState);

        return rules;
    }

    private void isRuleSelected(ArrayList<Rule> rules, JCheckBox ruleDisable, JComboBox<String> ruleDirection, JComboBox<Integer> ruleState, JComboBox<Integer> ruleCellValue, JComboBox<Integer> ruleNewCellValue, JComboBox<Integer> ruleNewState)
    {
        String firstChar;
        if(!ruleDisable.isSelected())
        {
            firstChar = ((String) ruleDirection.getSelectedItem()).substring(0,1);
            Rule rule = new Rule((Integer) ruleState.getSelectedItem(), (Integer) ruleCellValue.getSelectedItem(), Rule.returnDirection(firstChar), (Integer) ruleNewCellValue.getSelectedItem(), (Integer) ruleNewState.getSelectedItem());
            rules.add(rule);
        }
    }

    private void saveSettings(String fileName)
    {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));)
        {
            outputStream.writeObject(Application.centerPanel.gridValues);
            outputStream.writeObject(Application.centerPanel.turmite);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void loadSettings(String fileName)
    {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));)
        {
            Application.centerPanel.activeSim = false;
            Application.centerPanel.gridValues = (int[][]) inputStream.readObject();
            Application.centerPanel.activeSim = true;
            Application.centerPanel.turmite = new Turmite();
            Application.centerPanel.turmite = (Turmite) inputStream.readObject();
            setRuleBoxes();
            Application.centerPanel.turmite.start();
            Application.centerPanel.repaint();
            repaint();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    private transient ActionListener changeListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Application.centerPanel.turmite.initRules(readRules());
        }
    };

    private void setRuleBoxes()
    {
        ArrayList<Rule> rules = Application.centerPanel.turmite.getRules();
        if(!rules.isEmpty())
        {
            rule1State.setSelectedItem(rules.get(0).state);
            rule1CellValue.setSelectedItem(rules.get(0).cellValue);
            rule1Direction.setSelectedIndex(returnDirectionIndex(rules.get(0).direction));
            rule1NewCellValue.setSelectedItem(rules.get(0).newCellValue);
            rule1NewState.setSelectedItem(rules.get(0).newState);

            rule2State.setSelectedItem(rules.get(1).state);
            rule2CellValue.setSelectedItem(rules.get(1).cellValue);
            rule2Direction.setSelectedIndex(returnDirectionIndex(rules.get(1).direction));
            rule2NewCellValue.setSelectedItem(rules.get(1).newCellValue);
            rule2NewState.setSelectedItem(rules.get(1).newState);

            if(rules.size()>=3)
            {
                rule3Disable.setSelected(false);
                rule3State.setSelectedItem(rules.get(2).state);
                rule3CellValue.setSelectedItem(rules.get(2).cellValue);
                rule3Direction.setSelectedIndex(returnDirectionIndex(rules.get(2).direction));
                rule3NewCellValue.setSelectedItem(rules.get(2).newCellValue);
                rule3NewState.setSelectedItem(rules.get(2).newState);
                if(rules.size()==4)
                {
                    rule4Disable.setSelected(false);
                    rule4State.setSelectedItem(rules.get(3).state);
                    rule4CellValue.setSelectedItem(rules.get(3).cellValue);
                    rule4Direction.setSelectedIndex(returnDirectionIndex(rules.get(3).direction));
                    rule4NewCellValue.setSelectedItem(rules.get(3).newCellValue);
                    rule4NewState.setSelectedItem(rules.get(3).newState);
                }
                else
                {
                    rule4Disable.setSelected(true);
                }
            }
            else
            {
                rule3Disable.setSelected(true);
                rule4Disable.setSelected(true);
            }
        }
    }

    private int returnDirectionIndex(Rule.Direction dir)
    {
        return switch (dir)
        {
            case RIGHT -> 0;
            case LEFT -> 1;
            case NOTURN -> 2;
            case UTURN -> 3;
        };
    }
}
