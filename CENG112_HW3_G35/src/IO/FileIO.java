package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Model.Inventory;
import Model.Product;

public class FileIO {
    public static void readCSV(String filePath, Inventory inventory) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String command = parts[0];
                switch (command) {
                    case "add":
                        String category = parts[1];
                        String product = parts[2];
                        double price = Double.parseDouble(parts[3]);
                        inventory.addProduct(new Product(product, category, price));
                        System.out.println("Adding:\n Product: " + product + ", Category: " + category + ", Price: " + price + "₺");
                        break;
                    case "search":
                        String searchProduct = parts[1];
                        boolean found = inventory.searchProduct(searchProduct);
                        System.out.println("Searching:\n " + (found ? "Found: " + searchProduct : "Not Found: " + searchProduct));
                        break;
                    case "list":
                        System.out.println("Listing:");
                        for (Product p : inventory.listProducts()) {
                            System.out.println(p);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

