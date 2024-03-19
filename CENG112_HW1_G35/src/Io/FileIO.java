package Io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Data_Structures.Dictionary;
import Data_Structures.Text;
import Entities.Word;

public class FileIO {
    public static void readFile(Text<Word> text, Dictionary<Word> dictionary) {
        try (BufferedReader reader = new BufferedReader(new FileReader("../text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        Word newWord = new Word(word.toLowerCase());
                        text.add(newWord);
                        dictionary.add(newWord);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
