package Data_Structures;

public class Bag<T> implements IBag<T> {

	
    private T[] baga;
    private int size;

    @SuppressWarnings("unchecked")
    public Bag() {
        bag = (T[]) new Object[size];
        size = 0;
    }
    
	@Override
	public boolean add(T newEntry) {
		Bag<Object> a = new Bag<Object>(); 
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T removeByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndexOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
