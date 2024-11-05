package org.example.games.LinkedListTest;

import LinkedList.LinkedListCore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LinkedListCoreTest {
    private LinkedListCore<Integer> list;

    @BeforeEach
    public void setUp() {
            list = new LinkedListCore<>();
    }

    @Test
    public void testAddHead() {
        list.addHead(10);
        assertEquals("10 -> null", list.toString());
        assertEquals(1, list.size());

        list.addHead(20);
        assertEquals("20 -> 10 -> null", list.toString());
        assertEquals(2, list.size());
    }

    @Test
    public void testAddTail() {
        list.addTail(10);
        assertEquals("10 -> null", list.toString());
        assertEquals(1, list.size());

        list.addTail(20);
        assertEquals("10 -> 20 -> null", list.toString());
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveHead() {
        list.addHead(10);
        list.addHead(20);
        assertEquals("20 -> 10 -> null", list.toString());

        list.removeHead();
        assertEquals("10 -> null", list.toString());
        assertEquals(1, list.size());

        list.removeHead();
        assertEquals("null", list.toString());
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveTail() {
        list.addTail(10);
        list.addTail(20);
        list.addTail(30);
        assertEquals("10 -> 20 -> 30 -> null", list.toString());

        list.removeTail();
        assertEquals("10 -> 20 -> null", list.toString());
        assertEquals(2, list.size());

        list.removeTail();
        assertEquals("10 -> null", list.toString());
        assertEquals(1, list.size());

        list.removeTail();
        assertEquals("null", list.toString());
        assertEquals(0, list.size());
    }

    @Test
    public void testInsert() {
        list.addTail(10);
        list.addTail(30);

        list.insert(1, 20);
        assertEquals("10 -> 20 -> 30 -> null", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void testUpdate() {
        list.addTail(10);
        list.addTail(20);
        list.addTail(30);

        list.update(1, 25);
        assertEquals("10 -> 25 -> 30 -> null", list.toString());

        list.update(0, 15);
        assertEquals("15 -> 25 -> 30 -> null", list.toString());

        list.update(2, 35);
        assertEquals("15 -> 25 -> 35 -> null", list.toString());
    }

    @Test
    public void testDeleteByIndex() {
        list.addTail(10);
        list.addTail(20);
        list.addTail(30);

        list.delete(1);  // 20'yi sil
        assertEquals("10 -> 30 -> null", list.toString());
        assertEquals(2, list.size());

        list.delete(0);  // 10'u sil
        assertEquals("10 -> null", list.toString());
        assertEquals(1, list.size());

        list.delete(0);  // 30'u sil
        assertEquals("null", list.toString());
        assertEquals(0, list.size());
    }

    @Test
    public void testDeleteByValue() {
        list.addTail(10);
        list.addTail(20);
        list.addTail(30);

        list.delete(Integer.valueOf(20));  // 20'yi sil
        assertEquals("10 -> 30 -> null", list.toString());
        assertEquals(2, list.size());

        list.delete(Integer.valueOf(10));  // 10'u sil
        assertEquals("30 -> null", list.toString());
        assertEquals(1, list.size());

        list.delete(Integer.valueOf(30));  // 30'u sil
        assertEquals("null", list.toString());
        assertEquals(0, list.size());
    }

    @Test
    public void testDeleteAll() {
        list.addTail(10);
        list.addTail(20);
        list.addTail(30);

        list.deleteAll();
        assertEquals("null", list.toString());
        assertEquals(0, list.size());
    }

    @Test
    public void testToArray() {
        list.addTail(10);
        list.addTail(20);
        list.addTail(30);

        Object[] array = list.toArray();
        assertArrayEquals(new Object[]{10, 20, 30}, array);
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.addTail(10);
        assertEquals(1, list.size());
        list.addTail(20);
        assertEquals(2, list.size());
    }

}
