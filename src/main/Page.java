package main;

import java.util.*;

/**
 * Stores first letters of student names'
 */
public class Page implements Comparable<Page> {

    private Set<Character> letters; // all first name letters

    /**
     * Class constructor
     */
    public Page(){
        letters = new HashSet<Character>();
    }

    /**
     * Adds a letter to the page
     * @param letter letter to add
     */
    public void addLetter(char letter){
        letters.add(Character.toLowerCase(letter));
    }

    /**
     * Compares this page to the specified one
     * @param other page to compare to
     * @return -1 if the current page has less letters in it, 0 if both pages have the same number of letters, 1 if the other page has more letters in it
     */
    public int compareTo(Page other){
        if(getNumberOfDistinctLetters() > other.getNumberOfDistinctLetters()){
            return 1;
        }else if(getNumberOfDistinctLetters() < other.getNumberOfDistinctLetters()){
            return -1;
        }

        return 0;
    }

    /**
     * Gets the number of distinct letters in this page
     * @return
     */
    public int getNumberOfDistinctLetters(){
        return letters.size();
    }
}
