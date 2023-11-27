import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TurmiteTest
{
    Turmite turmite;

    @Before
    public void init()
    {
        turmite = new Turmite();
    }

    @Test
    public void setPosTest()
    {
        turmite.setPos(1,45);
        Assert.assertEquals(1, turmite.getxPos());
        Assert.assertEquals(45, turmite.getyPos());
    }

    @Test
    public void setGetRulesTest()
    {
        Rule rule = new Rule(0,0, Rule.Direction.RIGHT,0,0);
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(rule);
        rules.add(rule);
        rules.add(rule);
        rules.add(rule);

        Assert.assertNull(turmite.getRules());
        turmite.initRules(rules);
        Assert.assertEquals(rules,turmite.getRules());
    }
}
