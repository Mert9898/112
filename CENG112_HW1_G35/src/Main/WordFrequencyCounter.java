package Main;
import Entities.Word;
import Data_Structures.FrequentWordsDictionary;
import Data_Structures.Dictionary;
import Data_Structures.Text;
import Data_Structures.MostFrequentWordsDictionary;
import Data_Structures.RareWordsDictionary;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Text<Word> text = new Text<>();
        Dictionary<Word> dictionary = new Dictionary<>();
        RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<>();
        FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<>();
        MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>();

        text.displayItems();
        System.out.println("Text Size: " + text.getCurrentSize());

        text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);

        System.out.println("\nRare Words Dictionary:");
        rareWordsDictionary.displayItems();
        System.out.println("Size: " + rareWordsDictionary.getCurrentSize());

        System.out.println("\nFrequent Words Dictionary:");
        frequentWordsDictionary.displayItems();
        System.out.println("Size: " + frequentWordsDictionary.getCurrentSize());

        System.out.println("\nMost Frequent Words Dictionary:");
        mostFrequentWordsDictionary.displayItems();
        System.out.println("Size: " + mostFrequentWordsDictionary.getCurrentSize());
    }
}