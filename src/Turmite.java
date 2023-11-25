import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turmite extends Thread implements Serializable
{
    private List<Rule> rules;
    private int xPos;
    private int yPos;
    private int state;

    public enum FaceDirection
    {
        NORTH,WEST,SOUTH,EAST
    }

    private FaceDirection faceDirection;

    public Turmite()
    {
        reset();
    }

    public void setPos(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void reset()
    {
        setPos(Application.centerPanel.gridWidth/2, Application.centerPanel.gridHeight/2);
        faceDirection = FaceDirection.NORTH;
        state = 0;
    }

    public int getxPos()
    {
        return xPos;
    }

    public int getyPos()
    {
        return yPos;
    }


    public void initRules(ArrayList<Rule> rules)
    {
        this.rules = rules;
    }

    public void step()
    {
        Rule currentRule = findMatchingRule();

        if (currentRule != null) {
            updateDirectionAndPosition(currentRule);
        }
    }

    private Rule findMatchingRule() {
        for (Rule rule : rules) {
            if (rule.state == this.state && rule.cellValue == Application.centerPanel.gridValues[xPos][yPos]) {
                return rule;
            }
        }
        return null;
    }

    private void updateDirectionAndPosition(Rule currentRule) {
        switch (faceDirection) {
            case NORTH: updateForNorthDirection(currentRule); break;
            case WEST: updateForWestDirection(currentRule); break;
            case SOUTH: updateForSouthDirection(currentRule); break;
            case EAST: updateForEastDirection(currentRule); break;
        }
    }

    private void updateForNorthDirection(Rule currentRule) {
        switch (currentRule.direction) {
            case RIGHT: move(FaceDirection.EAST, 1, 0, currentRule.newCellValue, currentRule.newState); break;
            case LEFT: move(FaceDirection.WEST, -1, 0, currentRule.newCellValue, currentRule.newState); break;
            case NOTURN: move(faceDirection, 0, -1, currentRule.newCellValue, currentRule.newState); break;
            case UTURN: move(FaceDirection.SOUTH, 0, 1, currentRule.newCellValue, currentRule.newState); break;
        }
    }

    private void updateForWestDirection(Rule currentRule) {
        switch (currentRule.direction) {
            case RIGHT: move(FaceDirection.NORTH, 0, -1, currentRule.newCellValue, currentRule.newState); break;
            case LEFT: move(FaceDirection.SOUTH, 0, 1, currentRule.newCellValue, currentRule.newState); break;
            case NOTURN: move(faceDirection, -1, 0, currentRule.newCellValue, currentRule.newState); break;
            case UTURN: move(FaceDirection.EAST, 1, 0, currentRule.newCellValue, currentRule.newState); break;
        }
    }

    private void updateForSouthDirection(Rule currentRule) {
        switch (currentRule.direction) {
            case RIGHT: move(FaceDirection.WEST, -1, 0, currentRule.newCellValue, currentRule.newState); break;
            case LEFT: move(FaceDirection.EAST, 1, 0, currentRule.newCellValue, currentRule.newState); break;
            case NOTURN: move(faceDirection, 0, 1, currentRule.newCellValue, currentRule.newState); break;
            case UTURN: move(FaceDirection.NORTH, 0, -1, currentRule.newCellValue, currentRule.newState); break;
        }
    }

    private void updateForEastDirection(Rule currentRule) {
        switch (currentRule.direction) {
            case RIGHT: move(FaceDirection.SOUTH, 0, 1, currentRule.newCellValue, currentRule.newState); break;
            case LEFT: move(FaceDirection.NORTH, 0, -1, currentRule.newCellValue, currentRule.newState); break;
            case NOTURN: move(faceDirection, 1, 0, currentRule.newCellValue, currentRule.newState); break;
            case UTURN: move(FaceDirection.WEST, -1, 0, currentRule.newCellValue, currentRule.newState); break;
        }
    }

    private void move(FaceDirection newDirection, int xIncrement, int yIncrement, int newCellValue, int newState) {
        faceDirection = newDirection;
        Application.centerPanel.gridValues[xPos][yPos] = newCellValue;
        xPos = (xPos + xIncrement + Application.centerPanel.gridWidth) % Application.centerPanel.gridWidth;
        yPos = (yPos + yIncrement + Application.centerPanel.gridHeight) % Application.centerPanel.gridHeight;
        state = newState;
    }

    @Override
    public void run()
    {
        while (true)
        {
            if(Application.centerPanel.isRunning)
            {
                step();
                Application.centerPanel.repaint();
                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
