import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridPanelTest
{
    @Test
    public void ctorTest()
    {
        GridPanel gridPanel = new GridPanel(100,100);
        Assert.assertEquals(100, GridPanel.gridWidth);
        Assert.assertEquals(100, GridPanel.gridHeight);

        for (int y = 0; y < GridPanel.gridHeight; y++)
        {
            for (int x = 0; x < GridPanel.gridWidth; x++)
            {
                Assert.assertEquals(0,gridPanel.gridValues[x][y]);
            }
        }

        Assert.assertFalse(gridPanel.isRunning);
        Assert.assertTrue(gridPanel.activeSim);
        Assert.assertNotNull(gridPanel.turmite);
    }

    @Test
    public void resetSimTest()
    {
        GridPanel gridPanel = new GridPanel(100,100);
        gridPanel.gridValues[21][12]=1;
        gridPanel.isRunning=true;
        gridPanel.resetSim();
        Assert.assertFalse(gridPanel.isRunning);
        for (int y = 0; y < GridPanel.gridHeight; y++)
        {
            for (int x = 0; x < GridPanel.gridWidth; x++)
            {
                Assert.assertEquals(0,gridPanel.gridValues[x][y]);
            }
        }
    }
}
