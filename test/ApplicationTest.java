import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest
{
    @Test
    public void ctorTest()
    {
        Assert.assertNull(Application.centerPanel);

        Application app = new Application();

        Assert.assertNotNull(app);
        Assert.assertEquals("Turmite simulation", app.getTitle());
        Assert.assertNotNull(Application.centerPanel);
    }
}
