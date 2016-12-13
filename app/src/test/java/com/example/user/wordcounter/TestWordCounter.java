package com.example.user.wordcounter;
import org.junit.Test;
import org.junit.Before;

import java.util.HashMap;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by User on 13/12/2016.
 */
public class TestWordCounter {
    WordCounter counter;
    String test1;
    String test2;
    String test3;


    @Before
    public void initialize () {
        counter = new WordCounter();
        test1 = new String("one two two three three three four four four four");
        test2 = new String("Here we go again. Again, here I am. Go.");
        test3 = new String("it was the best of times it was the worst of times it was the age of wisdom it was the age of foolishness it was the epoch of belief it was the epoch of incredulity");
    }

    @Test
    public void testSimpleString() {
        HashMap<String, Integer> result = counter.getCount(test1);
        assertNotNull(result);
        assertEquals(3, (int)result.get("three"));
        assertEquals(4, (int)result.get("four"));
    }

    @Test
    public void testComplexString() {
        HashMap<String, Integer> result = counter.getCount(test2);
        assertNotNull(result);
        assertEquals(2, (int)result.get("here"));
        assertEquals(1, (int)result.get("we"));
    }

    @Test
    public void testGetCountAsSortedArray() {
        ArrayList<String> result = counter.getCountAsSortedArray(test3);
        assertEquals("times: 2", result.get(5));
    }

}
