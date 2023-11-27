import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPanelTest
{
    MenuPanel menuPanel;
    @Before
    public void init()
    {
        menuPanel = new MenuPanel();
    }

    @Test
    public void disableRulesTest()
    {
        JCheckBox rule3Disable = findCheckBox(menuPanel, "rule3Disable");
        JComboBox rule3State = findComboBox(menuPanel, "rule3State");
        Assert.assertNotNull(rule3Disable);
        Assert.assertNotNull(rule3State);
        rule3Disable.doClick();
        Assert.assertFalse(rule3State.isEnabled());

        JCheckBox rule4Disable = findCheckBox(menuPanel, "rule4Disable");
        JComboBox rule4State = findComboBox(menuPanel, "rule4State");
        Assert.assertNotNull(rule4Disable);
        Assert.assertNotNull(rule4State);
        rule4Disable.doClick();
        Assert.assertFalse(rule4State.isEnabled());
    }

    private JCheckBox findCheckBox(Container container, String name)
    {
        Component[] components = container.getComponents();
        for (Component component : components)
        {
            if (component instanceof JCheckBox)
            {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.getName().equals(name))
                {
                    return checkBox;
                }
            } else if (component instanceof Container)
            {
                JCheckBox checkBox = findCheckBox((Container) component, name);
                if (checkBox != null)
                {
                    return checkBox;
                }
            }
        }
        return null;
    }

    private JComboBox findComboBox(Container container, String name)
    {
        Component[] components = container.getComponents();
        for (Component component : components)
        {
            if (component instanceof JComboBox)
            {
                JComboBox comboBox = (JComboBox) component;
                if (comboBox.getName() != null && comboBox.getName().equals(name))
                {
                    return comboBox;
                }
            } else if (component instanceof Container)
            {
                JComboBox comboBox = findComboBox((Container) component, name);
                if (comboBox != null)
                {
                    return comboBox;
                }
            }
        }
        return null;
    }
}
