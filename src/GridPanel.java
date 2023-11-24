import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel
{
    public static int gridWidth;
    public static int gridHeight;

    private int cellWidth;

    private Polygon[][] grid;
    public int[][] gridValues;

    public volatile boolean isRunning;
    Turmite turmite;

    public GridPanel(int width, int height)
    {
        this.setPreferredSize(new Dimension(1010,1010));
        gridWidth = width;
        gridHeight = height;
        cellWidth = 10;
        isRunning = false;

        grid = new Polygon[gridWidth][gridHeight];
        gridValues = new int[gridWidth][gridHeight];

        for(int y=0;y<gridHeight;y++)
        {
            for(int x=0;x<gridWidth;x++)
            {
                int[] xPoints= new int[]{x*cellWidth,x*cellWidth+cellWidth,x*cellWidth+cellWidth,x*cellWidth};
                int[] yPoints= new int[]{y*cellWidth,y*cellWidth,y*cellWidth+cellWidth,y*cellWidth+cellWidth};
                grid[x][y] = new Polygon(xPoints,yPoints,4);
                gridValues[x][y] = 0;
            }
        }

        turmite = new Turmite();
        turmite.start();
    }

    public void resetSim()
    {
        isRunning=false;
        for (int y = 0; y < gridHeight; y++)
        {
            for (int x = 0; x < gridWidth; x++)
            {
                gridValues[x][y] = 0;
            }
        }

        turmite.reset();
        this.repaint();
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(int y=0;y<gridHeight;y++)
        {
            for(int x=0;x<gridWidth;x++)
            {
                if(gridValues[x][y] == 1)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(grid[x][y]);
                }
                else
                {
                    g.setColor(Color.white);
                    g.fillPolygon(grid[x][y]);
                }
                g.setColor(Color.black);
                g.drawPolygon(grid[x][y]);
            }
        }

        g.setColor(Color.red);
        g.fillPolygon(grid[turmite.getxPos()][turmite.getyPos()]);
        g.setColor(Color.black);
    }
}
