package From_CSV_to_Products.c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Product {
    private String name;
    private String category;
    private double price;
    private int quantitySold;
    private Date date;

    // Constructor
    public Product(String name, String category, double price, int quantitySold, Date date) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantitySold = quantitySold;
        this.date = date;
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

    public int getQuantitySold() {
        return quantitySold;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Method to read data from CSV and transform into Product objects with enhanced error handling
    public static List<Product> readCSV(String filePath) throws IOException, ParseException {
        List<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            // Skip header line
            br.readLine();

            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] data = line.split(",");
                if (data.length != 5) {
                    throw new IllegalArgumentException("Invalid data format at line " + lineNumber);
                }

                String name = data[0].trim();
                String category = data[1].trim();
                double price;
                int quantitySold;
                Date date;

                try {
                    price = Double.parseDouble(data[2].trim());
                    quantitySold = Integer.parseInt(data[3].trim());
                    date = dateFormat.parse(data[4].trim());
                } catch (NumberFormatException | ParseException e) {
                    throw new ParseException("Error parsing data at line " + lineNumber, lineNumber);
                }

                Product product = new Product(name, category, price, quantitySold, date);
                productList.add(product);
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + e.getMessage());
        }

        return productList;
    }

    // Method to remove duplicate entries
    public static List<Product> removeDuplicates(List<Product> productList) {
        Set<Product> uniqueProducts = new LinkedHashSet<>(productList);
        return new ArrayList<>(uniqueProducts);
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(date);

        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price= $" + price +
                ", quantitySold=" + quantitySold +
                ", date=" + formattedDate +
                '}';
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + Double.hashCode(price);
        result = prime * result + quantitySold;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(category, other.category) &&
                Double.compare(price, other.price) == 0 &&
                quantitySold == other.quantitySold &&
                Objects.equals(date, other.date);
    }
}
