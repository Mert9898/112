package Model;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    
    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node<T> addRecursive(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = addRecursive(node.right, data);
        }

        return node;
    }

    public boolean search(T data) {
        return searchRecursive(root, data) != null;
    }

    private Node<T> searchRecursive(Node<T> node, T data) {
        if (node == null || data.compareTo(node.data) == 0) {
            return node;
        }

        if (data.compareTo(node.data) < 0) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(Node<T> node, List<T> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.data);
            inOrderTraversal(node.right, list);
        }
    }
}

