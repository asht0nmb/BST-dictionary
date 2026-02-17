
// This class provides spell checking functionality by loading a dictionary of
// correctly spelled words and checking user-provided text against that dictionary.
// The SpellChecker uses a Dictionary data structure to store words from a file and
// identifies misspelled words by comparing input text against the loaded dictionary.
// All word comparisons are case-insensitive and non-alphabetic characters are removed.

import java.util.*;
import java.io.*;

public class SpellChecker {
   private Dictionary<String> dictionary;

    // Behavior: Constructs a SpellChecker by initializing it with the given dictionary
    //           and loading words from the specified file into the dictionary.
    // Parameters: 
    //      dictionary - the Dictionary to store correctly spelled words
    //      filename - the name of the file containing dictionary words
    // Exceptions: 
    //   throws IllegalArgumentException if dictionary is null
    //   throws IllegalArgumentException if filename is null or empty
    public SpellChecker(Dictionary<String> dictionary, String filename) {
        // excetion: checks for null dictionary
        if (dictionary == null) {
            throw new IllegalArgumentException("Dictionary cannot be null");
        }
        // exception: checks for null/empty filename
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        this.dictionary = dictionary;
        loadFile(filename);
    }

    // Behavior: Loads words from a file into the dictionary, cleaning each word
    //           by converting to lowercase and removing non-alphabetic characters
    // Parameters: filename - the path to the file containing dictionary words
    // Exceptions: none (catches FileNotFoundException internally)
    private void loadFile(String filename) {
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNext()) {           // loops until .hasNext returns false
                String word = input.next();  

                // cleaning
                word = word.toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {          // blank word prevention
                    dictionary.insert(word);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + filename);
        }
    }

    // Behavior: Checks the given text for spelling errors by comparing each word
    //           against the dictionary. Returns a list of all misspelled words found.
    //           Words are converted to lowercase and non-alphabetic characters are
    //           removed before checking.
    // Parameters: text - the text to check for spelling errors
    // Returns: a List of Strings containing all misspelled words found in the text
    // Exceptions: IllegalArgumentException if text is null
    public List<String> check(String text) {
        // exception: checks for null txt
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        List<String> incorrectWords = new ArrayList<>();
        String cleanText = text.toLowerCase();
        String[] words = cleanText.split("\\s+");           // splits on whitespace
        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll("[^a-z]", "");
            if (!word.isEmpty() && !dictionary.contains(word)) {
                incorrectWords.add(word);
            }

        }
        return incorrectWords;
    }
}