package com.example.user.wordcounter;
import org.junit.Test;
import org.junit.Before;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by User on 13/12/2016.
 */
public class TestWordCounter {
    WordCounter counter;
    String test1;
    String test2;


    @Before
    public void initialize () {
        counter = new WordCounter();
        test1 = new String("one two two three three three four four four four");
        test2 = new String("Here we go again. Again, here I am. Go.");
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

}
