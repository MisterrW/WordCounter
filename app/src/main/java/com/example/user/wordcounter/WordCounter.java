package com.example.user.wordcounter;

import java.util.HashMap;

/**
 * Created by User on 13/12/2016.
 */
public class WordCounter {

    public HashMap<String, Integer> getCount(String inputString) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        String [] words = inputString.split("[\\W]");
       for (String word : words) {
           word = word.toLowerCase();
           if(result.get(word) == null) {
               result.put(word, 1);
           } else {
               result.put(word, result.get(word)+1);
           }
       }
        return result;

    }
}
