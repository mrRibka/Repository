import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestModel {
    private Model model;
    @Before
    public void runTest(){
        model = new Model();
    }
    @Test
    public void testNumberIsInRange(){
        model.SetGuessNumber(50);
        org.junit.Assert.assertTrue(model.NumberIsInRange());
        model.SetGuessNumber(500);
        org.junit.Assert.assertFalse(model.NumberIsInRange());
    }

    @Test
    public void testCompare(){
        model.SetGuessNumber(50);
        model.SetValue(50);
        org.junit.Assert.assertEquals(model.Compare(), "equal");
        model.SetValue(51);
        org.junit.Assert.assertEquals(model.Compare(), "greater");
        model.SetValue(49);
        org.junit.Assert.assertEquals(model.Compare(), "less");
    }
}
