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
        MySortedSet<String> instance = new MySortedSet<>();
        instance.add("qwe");
        instance.add("qwe");
        instance.add("qwe");
        instance.add("qwe");
        instance.add("qwe");
        instance.add("qwe");
        instance.add("asd");
        instance.add("zxc");
        instance.add("52345");
        instance.add("52345");
        instance.add("52345");
        instance.add("52345");
        instance.add("52345");
        instance.add("52345");
        instance.add("52345");

    }

    /**
     * Test of remove method, of class MySortedSet.
     */
    @org.junit.Test
    public void testRemove() {
        MySortedSet<String> instance = new MySortedSet<>();
        instance.add("qwe");
        instance.add("asd");
        instance.add("zxc");
        instance.add("52345");
        instance.add("5234asd");
        instance.add("52342");
        instance.add("52344");
        instance.add("52343");
        assertTrue(instance.contains("qwe"));
        assertTrue(instance.contains("asd"));
        assertTrue(instance.contains("zxc"));
        assertTrue(instance.contains("52345"));
        assertTrue(instance.contains("5234asd"));
        assertTrue(instance.contains("52342"));
        assertTrue(instance.contains("52344"));
        assertTrue(instance.contains("52343"));
        assertTrue(instance.remove("52342"));
        assertFalse(instance.remove("bdfg"));
        assertTrue(instance.contains("qwe"));
        assertTrue(instance.contains("asd"));
        assertTrue(instance.contains("zxc"));
        assertTrue(instance.contains("52345"));
        assertTrue(instance.contains("5234asd"));
        assertFalse(instance.contains("52342"));
        assertTrue(instance.contains("52344"));
        assertTrue(instance.contains("52343"));
        assertTrue(instance.remove("qwe"));
        assertFalse(instance.contains("qwe"));
        assertTrue(instance.contains("asd"));
        assertTrue(instance.contains("zxc"));
        assertTrue(instance.contains("52345"));
        assertTrue(instance.contains("5234asd"));
        assertFalse(instance.contains("52342"));
        assertTrue(instance.contains("52344"));
        assertTrue(instance.contains("52343"));
    }

    /**
     * Test of contains method, of class MySortedSet.
     */
    @org.junit.Test

    public void testContains() {
        MySortedSet<String> instance = new MySortedSet<>();
        instance.add("qwe");
        instance.add("asd");
        instance.add("zxc");
        instance.add("52345");
        instance.add("5234asd");
        instance.add("52342");
        instance.add("52344");
        instance.add("52343");
        assertTrue(instance.contains("qwe"));
        assertTrue(instance.contains("asd"));
        assertTrue(instance.contains("zxc"));
        assertTrue(instance.contains("52345"));
        assertTrue(instance.contains("5234asd"));
        assertTrue(instance.contains("52343"));
        assertFalse(instance.contains("hgdsd"));

    }

    /**
     * Test of iterator method, of class MySortedSet.
     */
    @org.junit.Test

    public void testIterator() {
        MySortedSet<String> instance = new MySortedSet<>();
        instance.add("qwe");
        instance.add("asd");
        instance.add("zxc");
        Iterator<String> it = instance.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
