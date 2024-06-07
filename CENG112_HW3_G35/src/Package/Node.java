package Package;

public class Node {

	
	public class Node<T> {
	    T data;
	    Node<T> left, right;
	    
	    public Node(T data) {
	        this.data = data;
	        left = right = null;
	    }
	}

}
