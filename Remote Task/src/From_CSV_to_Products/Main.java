//package From_CSV_to_Products;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Read CSV file and create list of products
//            List<Product> productList = Product.readCSV("src/From_CSV_to_Products/your_csv_file.csv");
//
//            // Print original dataset
//            System.out.println("Original dataset:");
//            productList.forEach(System.out::println);
//
//            // Remove duplicates
//            List<Product> uniqueProducts = Product.removeDuplicates(productList);
//
//            // Print dataset after removing duplicates
//            System.out.println("\nDataset after removing duplicates:");
//            uniqueProducts.forEach(System.out::println);
//        } catch (IOException | ParseException e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
