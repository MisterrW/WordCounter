package com.example.user.wordcounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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

    public ArrayList<String> getCountAsSortedArray(String inputString) {
        HashMap<String, Integer> resultsHash = getCount(inputString);

        ArrayList<Word> wordsList = new ArrayList<Word>();
        Map<String, Integer> resultsMap = new HashMap(resultsHash);
        for (Map.Entry<String, Integer> entry : resultsMap.entrySet()) {
            String word = entry.getKey();
            int occurrence = entry.getValue();
            wordsList.add(new Word(word, occurrence));
        }

        Collections.sort(wordsList, new Comparator<Word>() {
            public int compare(Word word1, Word word2) {
                if (word1.getIncidence() > word2.getIncidence()) return -1;
                if (word1.getIncidence() < word2.getIncidence()) return 1;
                return 0;
            }
        });

        ArrayList<String> resultsListFromObjects = new ArrayList<String>();

        for (Word word : wordsList) {
            String pair = String.format(word.getWord() + ": " + word.getIncidence());
            resultsListFromObjects.add(pair);
        }
        return resultsListFromObjects;
    }

    public String getCountAsSortedString(String inputString) {

        ArrayList<String> resultsArray = getCountAsSortedArray(inputString);
        String results = resultsArray.toString();

        String results1 = (results.replaceAll("\\[", ""));
        String results2 = (results1.replaceAll("\\]", ""));
        return results2;
    }

}
