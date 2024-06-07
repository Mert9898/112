package Model;

public class Product implements Comparable<Product> {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product other) {
        int categoryComparison = this.category.compareTo(other.category);
        if (categoryComparison != 0) {
            return categoryComparison;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + category + "): " + price + "₺";
    }
}
