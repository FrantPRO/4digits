/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Lucky
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
}
