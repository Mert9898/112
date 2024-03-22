package Main;
import Entities.Word;
import Data_Structures.FrequentWordsDictionary;
import Data_Structures.Dictionary;
import Data_Structures.Text;
import Data_Structures.MostFrequentWordsDictionary;
import Data_Structures.RareWordsDictionary;
import Io.FileIO;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Text<Word> text = new Text<>();
        Dictionary<Word> dictionary = new Dictionary<>();
        RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<>();
        FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<>();
        MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>();
        FileIO.readFile(text, dictionary);
        text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);
        System.out.println("Text:");
        text.displayWithCount();
        System.out.println("");
        System.out.println("Rare Words Dictionary:");
        rareWordsDictionary.displayWithCount();
        System.out.println("");
        System.out.println("Frequent Words Dictionary:");
        frequentWordsDictionary.displayWithCount();
        System.out.println("");
        System.out.println("Most Frequent Words Dictionary:");
        mostFrequentWordsDictionary.displayWithCount();
    }
}