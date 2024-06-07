package Model;
import Model.Product;
public class Inventory {
    private Tree<Product> tree;

    public Inventory() {
        tree = new Tree<>();
    }

    public void addProduct(Product product) {
        tree.add(product);
    }

    public boolean searchProduct(String productName) {
        // Implement custom search logic if necessary
        return tree.search(new Product(productName, null, 0));
    }

    public List<Product> listProducts() {
        return tree.list();
    }
}
