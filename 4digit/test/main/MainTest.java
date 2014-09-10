/*
 * Class MainTest
 */
package main;

import java.text.ParseException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <strong >S.N. Frantsuzov, 2014</strong>
 * @version 1.0
 */
public class MainTest {

    Main instance;
    int[] array = {1, 2, 3, 4};

    public MainTest() throws ParseException {
        instance = new Main();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkUserNumber method, of class Main.
     */
    @Test
    public void checkUserNumber1() {
        System.out.println("checkUserNumber1");
        Assert.assertTrue(instance.checkUserNumber(array));
    }

    @Test
    public void checkUserNumber2() {
        System.out.println("checkUserNumber2");
        array[1] = 1;
        Assert.assertFalse(instance.checkUserNumber(array));
    }

    @Test
    public void checkUserNumber3() {
        System.out.println("checkUserNumber3");
        array[2] = 1;
        Assert.assertFalse(instance.checkUserNumber(array));
    }

    @Test
    public void checkUserNumber4() {
        System.out.println("checkUserNumber4");
        array[3] = 1;
        Assert.assertFalse(instance.checkUserNumber(array));
    }

    @Test
    public void checkUserNumber5() {
        System.out.println("checkUserNumber5");
        array[1] = 3;
        Assert.assertFalse(instance.checkUserNumber(array));
    }

    @Test
    public void checkUserNumber6() {
        System.out.println("checkUserNumber6");
        array[1] = 4;
        Assert.assertFalse(instance.checkUserNumber(array));
    }

    @Test
    public void checkUserNumber7() {
        System.out.println("checkUserNumber7");
        array[1] = 1;
        array[2] = 1;
        array[3] = 1;
        Assert.assertFalse(instance.checkUserNumber(array));
    }

    @Test(expected = NullPointerException.class)
    public void checkUserNumber8() {
        System.out.println("checkUserNumber8");
        Assert.assertEquals(instance.checkUserNumber(null), false);
    }

    /**
     * Test of setUserNumber method, of class Main.
     */
    @Test
    public void setUserNumber1() {
        char[] array = {'1', '2', '3', '4'};
        System.out.println("setUserNumber1");
        Assert.assertTrue(instance.setUserNumber(array));
    }

    @Test
    public void setUserNumber2() {
        char[] array = {'a', '2', '3', '4'};
        System.out.println("setUserNumber2");
        Assert.assertFalse(instance.setUserNumber(array));
    }

    @Test
    public void setUserNumber3() {
        char[] array = {'0', '0', '0', '0'};
        System.out.println("setUserNumber3");
        Assert.assertFalse(instance.setUserNumber(array));
    }

    @Test(expected = NullPointerException.class)
    public void setUserNumber4() {
        char[] array = null;
        System.out.println("setUserNumber4");
        Assert.assertFalse(instance.setUserNumber(array));
    }

    /**
     * Test of howCows method, of class Main.
     */
    @Test
    public void howCows1() {
        System.out.println("howCows1");
        int[] user = {};
        int[] comp = {};
        int expected = instance.howCows(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void howCows2() {
        System.out.println("howCows2");
        int[] user = null;
        int[] comp = null;
        int expected = instance.howCows(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows3() {
        System.out.println("howCows3");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 7, 8};
        int expected = instance.howCows(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows4() {
        System.out.println("howCows4");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 2, 3, 4};
        int expected = instance.howCows(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows5() {
        System.out.println("howCows5");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 2, 6, 7};
        int expected = instance.howCows(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows6() {
        System.out.println("howCows6");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 3, 7};
        int expected = instance.howCows(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows7() {
        System.out.println("howCows7");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 7, 4};
        int expected = instance.howCows(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows8() {
        System.out.println("howCows8");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 2, 7};
        int expected = instance.howCows(user, comp);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows9() {
        System.out.println("howCows9");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 7, 2};
        int expected = instance.howCows(user, comp);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows10() {
        System.out.println("howCows10");
        int[] user = {1, 2, 3, 4};
        int[] comp = {2, 5, 6, 7};
        int expected = instance.howCows(user, comp);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows11() {
        System.out.println("howCows11");
        int[] user = {1, 2, 3, 4};
        int[] comp = {2, 6, 1, 7};
        int expected = instance.howCows(user, comp);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows12() {
        System.out.println("howCows12");
        int[] user = {1, 2, 3, 4};
        int[] comp = {2, 5, 1, 3};
        int expected = instance.howCows(user, comp);
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howCows13() {
        System.out.println("howCows13");
        int[] user = {1, 2, 3, 4};
        int[] comp = {2, 4, 1, 3};
        int expected = instance.howCows(user, comp);
        int actual = 4;
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test of howCows method, of class Main.
     */
    @Test
    public void howBulls1() {
        System.out.println("howBulls1");
        int[] user = {};
        int[] comp = {};
        int expected = instance.howBulls(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void howBulls2() {
        System.out.println("howBulls2");
        int[] user = null;
        int[] comp = null;
        int expected = instance.howBulls(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls3() {
        System.out.println("howBulls3");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 7, 8};
        int expected = instance.howBulls(user, comp);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls4() {
        System.out.println("howBulls4");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 5, 6, 7};
        int expected = instance.howBulls(user, comp);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls5() {
        System.out.println("howBulls5");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 2, 6, 7};
        int expected = instance.howBulls(user, comp);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls6() {
        System.out.println("howBulls6");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 3, 7};
        int expected = instance.howBulls(user, comp);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls7() {
        System.out.println("howBulls7");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 7, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls8() {
        System.out.println("howBulls8");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 2, 5, 6};
        int expected = instance.howBulls(user, comp);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls9() {
        System.out.println("howBulls9");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 5, 3, 6};
        int expected = instance.howBulls(user, comp);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls10() {
        System.out.println("howBulls10");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 5, 6, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls11() {
        System.out.println("howBulls11");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 2, 6, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls12() {
        System.out.println("howBulls12");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 6, 3, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls13() {
        System.out.println("howBulls13");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 2, 3, 6};
        int expected = instance.howBulls(user, comp);
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls14() {
        System.out.println("howBulls14");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 2, 5, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void howBulls15() {
        System.out.println("howBulls15");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 5, 3, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }
    
      @Test
    public void howBulls16() {
        System.out.println("howBulls16");
        int[] user = {1, 2, 3, 4};
        int[] comp = {5, 2, 3, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howBulls17() {
        System.out.println("howBulls17");
        int[] user = {1, 2, 3, 4};
        int[] comp = {1, 2, 3, 4};
        int expected = instance.howBulls(user, comp);
        int actual = 4;
        Assert.assertEquals(expected, actual);
    }
}
