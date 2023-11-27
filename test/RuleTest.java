import org.junit.Assert;
import org.junit.Test;

public class RuleTest
{
    @Test
    public void returnDirTest()
    {
        Rule.Direction dir = Rule.returnDirection("R");
        Assert.assertEquals(Rule.Direction.RIGHT, dir);

        dir = Rule.returnDirection("L");
        Assert.assertEquals(Rule.Direction.LEFT, dir);

        dir = Rule.returnDirection("N");
        Assert.assertEquals(Rule.Direction.NOTURN, dir);

        dir = Rule.returnDirection("U");
        Assert.assertEquals(Rule.Direction.UTURN, dir);

        dir = Rule.returnDirection("Bármi ami nem jó direction");
        Assert.assertNull(dir);
    }

    @Test
    public void ctorTest()
    {
        Rule rule2 = new Rule();
        Assert.assertNotNull(rule2);
    }

    @Test
    public void paramCtorTest()
    {
        Rule rule = new Rule(0,1, Rule.Direction.LEFT,0,1);

        Assert.assertEquals(0,rule.state);
        Assert.assertEquals(1,rule.cellValue);
        Assert.assertEquals(Rule.Direction.LEFT, rule.direction);
        Assert.assertEquals(0,rule.newCellValue);
        Assert.assertEquals(1,rule.newState);
    }

    @Test
    public void toStringTest()
    {
        Rule rule = new Rule(0,1, Rule.Direction.LEFT,0,1);
        String expected = "0-1-L-0-1";

        Assert.assertEquals(expected, rule.toString());
    }
}
