import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import com.kangjian.test.DoSomeThing;
import org.junit.Test;

import static org.junit.Assert.*;

public class testDoSomeThingTest {
    public testDoSomeThingTest(){}
    @Before
    public void setUp(){
        System.out.println("this is setUp function");
    }
    @After
    public void tearDown(){
        System.out.println("this is tearDown function");
    }
    @Test
    public void testDoSomething(){
        DoSomeThing test = new DoSomeThing();
        String res = test.method();
        Assert.assertEquals("Error hahahahaa","kangjian",res);

    }
}