package Data_Structures;

import java.util.Arrays;

public class Bag<T> implements IBag<T> {

    private static final int DEFAULT_CAPACITY = 1000;
	private T[] bag;
	private boolean initialized = false;
	private int size;

    @SuppressWarnings("unchecked")
    public Bag() {
        bag = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        initialized = true;
    }
    
    private void checkInit() {
    	if (!initialized) {
    		throw new SecurityException("Bag is not initialized yet");
    		
    		
    	}
    }
    @Override
	public boolean add(T newEntry) {
		checkInit();
		if(isFull()) {
			doubleCap();
			bag[size] = newEntry;
			size += 1;
		}
		else {		
		bag[size] = newEntry;
		size += 1;}

		return true;
	}
    @Override
	public boolean isEmpty() {
		if(bag.length > 0) {
			return false;
		}
		return true;
	}
    @Override
	public boolean isFull() {
		if(bag.length >= DEFAULT_CAPACITY) {
			return true;
		}
		else {return false;}
		
	}

    public void doubleCap()
	{
		int new_cap = 2*DEFAULT_CAPACITY;
		bag = Arrays.copyOf(bag, new_cap);
		
	}
    @Override
	public T removeByIndex(int index) {
		checkInit();
		T result = null;
		if(!isEmpty() && (index >= 0)) {
			result = bag[index];
			bag[index]=bag[size-1];
			bag[size]=null;
			size--;
			
		}
		return result;
	}
    @Override
	public boolean remove(T anEntry) {
		checkInit();
		int index = getIndexOf(anEntry);
		T result = removeByIndex(index);
		
		return (anEntry.equals(result));
	}
    @Override
	public T remove() {
		checkInit();
		T result = null;
		if (!isEmpty()) {
			
			result = bag[size-1];
			bag[size-1]=null;
			size--;
		}
		return result;
	}
    @Override
	public int getFrequencyOf(T anEntry) {
		checkInit();
		int counter=0;
		for(counter=0;counter<bag.length;counter++) {}
			if(anEntry.equals(bag[counter])) {counter++;}
		return counter;
	}
    @Override
	public int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;
		while(!found && (index < bag.length)) {
			if(anEntry.equals(bag[index])) {
				found=true;
				where=index;
			}
			index++;
		}
		
		return where;
	}
    @Override
	public boolean contains(T anEntry) {
		checkInit();
		return getIndexOf(anEntry)>-1;
	}
    @Override
	public void clear() {
		while(!isEmpty()) {remove();}
		
	}


    public void displayItems() {
        checkInit();
        for (int i = 0; i < size; i++) {
            System.out.print(bag[i] + " ");
        }
        System.out.println();
    }

    public int getCurrentSize() {
        checkInit();
        return size;
    }

    public T[] toArray() {
        checkInit();
        return Arrays.copyOf(bag, size);
    }

}
