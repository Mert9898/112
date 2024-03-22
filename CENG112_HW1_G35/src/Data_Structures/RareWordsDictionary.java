package Data_Structures;

public class RareWordsDictionary<T> extends Bag<T> {
   
	public void displayWithCount() {
	    System.out.println("Number of words: " + getCurrentSize());
	    displayItems();
	}
	
}
