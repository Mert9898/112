package Data_Structures;

public class Dictionary<T> extends Bag<T> {
    
	public void displayWithCount() {
	    System.out.println("Number of words: " + getCurrentSize());
	    displayItems();
	}
	
}
