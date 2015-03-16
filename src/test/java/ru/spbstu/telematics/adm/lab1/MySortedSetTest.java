/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spbstu.telematics.adm.lab1;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author alexandr
 */
public class MySortedSetTest {

    public MySortedSetTest() {
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
     * Test of add method, of class MySortedSet.
     */
    @org.junit.Test
    public void testAdd() {
        MySortedSet instance = new MySortedSet();
        instance.add("qwe");
        instance.add("asd");
        instance.add("zxc");
        instance.add("52345");

    }

    /**
     * Test of remove method, of class MySortedSet.
     */
    @org.junit.Test
    public void testRemove() {
        System.out.println("remove");
        Comparable o = null;
        MySortedSet instance = new MySortedSet();
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class MySortedSet.
     */
    @org.junit.Test

    public void testContains() {
        MySortedSet instance = new MySortedSet();
        instance.add("qwe");
        instance.add("asd");
        instance.add("zxc");
        instance.add("52345");
        assertTrue(instance.contains("zxc"));
        assertTrue(instance.contains("qwe"));
        assertTrue(instance.contains("asd"));
        assertTrue(instance.contains("52345"));
        assertFalse(instance.contains("vcsdg"));
        

    }

    /**
     * Test of iterator method, of class MySortedSet.
     */
    @org.junit.Test

    public void testIterator() {
        System.out.println("iterator");
        MySortedSet instance = new MySortedSet();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
