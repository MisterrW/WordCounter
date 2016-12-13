package com.example.user.wordcounter;

/**
 * Created by User on 13/12/2016.
 */
public class Word {
    private String word;
    private int incidence;

    public Word(String word, int incidence) {
        this.word = word;
        this.incidence = incidence;
    }

    public String getWord(){
        return this.word;
    }

    public int getIncidence(){
        return this.incidence;
    }
}
