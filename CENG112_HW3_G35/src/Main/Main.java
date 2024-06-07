package Main;

import IO.FileIO;
import Model.Inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        FileIO.readCSV("Files/sample.csv", inventory);
    }
}
