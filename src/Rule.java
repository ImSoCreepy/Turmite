import java.io.Serializable;

public class Rule implements Serializable
{
    public int state;
    public int cellValue;
    public enum Direction
    {
        LEFT, RIGHT, NOTURN, UTURN
    }
    public Direction direction;
    public int newCellValue;
    public int newState;

    public Rule(){}

    public Rule(int state, int cellValue, Direction dir, int newCellValue, int newState)
    {
        this.state = state;
        this.cellValue = cellValue;
        this.direction = dir;
        this.newCellValue = newCellValue;
        this.newState = newState;
    }

    public static Direction returnDirection(String d)
    {
        return switch (d)
        {
            case "R" -> Direction.RIGHT;
            case "L" -> Direction.LEFT;
            case "N" -> Direction.NOTURN;
            case "U" -> Direction.UTURN;
            default -> null;
        };
    }
}
