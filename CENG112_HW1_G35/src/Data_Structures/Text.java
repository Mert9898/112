package Data_Structures;
import Entities.Word;

public class Text<T> extends Bag<T> {
	
	
    public void separate(Dictionary<Word> dictionary, 
            RareWordsDictionary<Word> rareWordsDictionary, 
            FrequentWordsDictionary<Word> frequentWordsDictionary, 
            MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary) {
    		
    		for (T word : toArray()) {
    			int frequency = getFrequencyOf(word);
    			if (frequency < 5) {
    				
    				rareWordsDictionary.add((Word) word);
    			} 
    			else if (frequency >= 5 && frequency <= 8) {
    				
    				frequentWordsDictionary.add((Word) word);
    			} 
    			else {
    				
    				mostFrequentWordsDictionary.add((Word) word);
    			}
    	   }
    	}
}
