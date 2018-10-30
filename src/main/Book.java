package main;

import com.sun.istack.internal.Nullable;

import java.util.*;

/**
 * Stores Page objects
 */
public class Book {

    private List<Page> pages; // all pages that are in the book

    /**
     * Class constructor
     */
    public Book(){
        pages = new ArrayList<Page>();
    }

    /**
     * Adds a page to the book
     * @param page
     */
    public void addPage(Page page){
        pages.add(page);
    }

    /**
     * Sorts all pages using the specified comparator
     * @param comparator Comparator to be used when sorting
     */
    public void sortPages(@Nullable Comparator<? super Page> comparator){
        pages.sort(comparator);
    }

    /**
     * Gets the maximum number of distinct name letters in a page
     * @return number of distinct letters
     */
    public int getMaximumNumberOfDistinctLetters(){
        return pages.get(pages.size() - 1).getNumberOfDistinctLetters();
    }

    /**
     * Gets the minimum number of distinct name letters in a page
     * @return number of distinct letters
     */
    public int getMinimumNumberOfDistinctLetters(){
        return pages.get(0).getNumberOfDistinctLetters();
    }
}
