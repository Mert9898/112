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
        System.out.println("Text Size: " + text.getCurrentSize());
        System.out.println("Size: " + rareWordsDictionary.getCurrentSize());
        System.out.println("Size: " + frequentWordsDictionary.getCurrentSize());
        System.out.println("Size: " + mostFrequentWordsDictionary.getCurrentSize());
    }
}