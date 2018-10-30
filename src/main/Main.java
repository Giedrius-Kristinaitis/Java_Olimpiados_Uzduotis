package main;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Main class of the program
 */
public class Main {

    /**
     * Entry point of the program
     * @param args arguments for the program
     */
    public static void main(String[] args) {
        Book book = new Book();

        readData(book, "data.txt");

        book.sortPages(null);

        int minNumberOfLetters = book.getMinimumNumberOfDistinctLetters();
        int maxNumberOfLetters = book.getMaximumNumberOfDistinctLetters();

        if (minNumberOfLetters != maxNumberOfLetters) {
            System.out.println("Minimalus skirtingų raidžių skaičius puslapyje: " + minNumberOfLetters);
            System.out.println("Maksimalus skirtingų raidžių skaičius puslapyje: " + maxNumberOfLetters);
        } else {
            System.out.println("Maksimalus ir minimalus raidžių skaičiai puslapyje sutampa ir yra " + minNumberOfLetters);
        }
    }

    /**
     * Reads data from the specified file and stores it in the specified Book object
     * @param book Book object to store page data in
     * @param file Name (path) of the file to read
     */
    public static void readData(Book book, String file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();
            String[] data = line.split(" ");
            int totalNumberOfNames = Integer.parseInt(data[0]);
            int numberOfNamesPerPage = Integer.parseInt(data[1]);

            Page currentPage = new Page();
            book.addPage(currentPage);

            for(int i = 0; i < totalNumberOfNames; i++){
                line = reader.readLine();

                if(currentPage.getNumberOfDistinctLetters() >= numberOfNamesPerPage) {
                    currentPage = new Page();
                    book.addPage(currentPage);
                }

                currentPage.addLetter(line.charAt(0));
            }

            reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
