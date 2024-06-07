package Model;
import Model.Product;
import Model.Tree;

import java.util.List;

public class Inventory {
    private Tree<Product> tree;

    public Inventory() {
        tree = new Tree<>();
    }

    public void addProduct(Product product) {
        tree.add(product);
    }

    public boolean searchProduct(String productName) {
        // Search the tree for a product with the given name
        List<Product> products = tree.list();
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> listProducts() {
        return tree.list();
    }
}

