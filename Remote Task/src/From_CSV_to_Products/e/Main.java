package From_CSV_to_Products.e;

import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Read CSV file and create list of products
            List<Product> productList = Product.readCSV("src/From_CSV_to_Products/e/your_csv_file.csv");

            // Calculate total amount for each product and find the one with the highest total
            Product highestTicketSale = productList.stream()
                    .max(Comparator.comparingDouble(p -> p.getPrice() * p.getQuantitySold()))
                    .orElse(null);

            // Print the product with the highest ticket
            System.out.println("\nSale with the highest ticket:");
            if (highestTicketSale != null) {
                System.out.println(highestTicketSale);
            } else {
                System.out.println("No products found.");
            }

            // Print original dataset
            System.out.println("Original dataset:");
            productList.forEach(System.out::println);

            // Remove duplicates
            List<Product> uniqueProducts = Product.removeDuplicates(productList);

            // Print dataset after removing duplicates
            System.out.println("\nDataset after removing duplicates:");
            uniqueProducts.forEach(System.out::println);
        } catch (IOException | ParseException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
