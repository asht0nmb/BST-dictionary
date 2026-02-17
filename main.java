// Ashton Meyer-Bibbins
// Updated: 02/16/2026

// This class demonstrates the spell checker functionality by loading a dictionary
// and checking user input for misspelled words. Users can also add new words
// to the dictionary interactively.

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Spell Checker Demo ==\n");
        
        // Create dictionary and spell checker
        Dictionary<String> dict = new BST<>();
        SpellChecker checker = new SpellChecker(dict, "dictionary.txt");
        
        System.out.println("Dictionary loaded with " + dict.size() + " words.\n");

        Scanner console = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter text to check: ");
        String text = console.nextLine();

        // Check spelling
        List<String> misspelled = checker.check(text);
        
        if (misspelled.isEmpty()) {
            System.out.println("\nNo misspelled words found!");
        } else {
            System.out.println("\nMisspelled words: " + misspelled);
            
            // Offer to add misspelled words
            for (String word : misspelled) {
                System.out.print("\nAdd '" + word + "' to dictionary? (y/n): ");
                String response = console.nextLine().toLowerCase();
                
                if (response.equals("y")) {
                    dict.insert(word);
                    System.out.println("'" + word + "' added to dictionary.");
                }
            }
            
            System.out.println("\nDictionary now contains " + dict.size() + " words.");
        }
        
        console.close();
    }
}