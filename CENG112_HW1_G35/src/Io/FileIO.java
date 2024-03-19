package Io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Data_Structures.Dictionary;
import Data_Structures.FrequentWordsDictionary;
import Data_Structures.MostFrequentWordsDictionary;
import Data_Structures.RareWordsDictionary;
import Data_Structures.Text;
import Entities.Word;

public class FileIO {
    public static void readFile(Text<Word> text, Dictionary<Word> dictionary) {
        try (BufferedReader reader = new BufferedReader(new FileReader("../text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Remove punctuation characters
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        // Convert word to lowercase
                        word = word.toLowerCase();
                        // Create a Word object
                        Word newWord = new Word(word);
                        // Add the word to the bags
                        text.add(newWord);
                        dictionary.add(newWord);
                    }
                }
            }

            // Initialize dictionaries
            RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<>();
            FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<>();
            MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>();

            // Call the separate method to categorize words
            text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
