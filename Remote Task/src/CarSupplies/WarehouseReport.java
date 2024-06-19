package CarSupplies;

import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WarehouseReport {

    public static void main(String[] args) throws Exception {
        String jsonData = "{\"components\": [\n" +
                "{ \"category\": \"Engine\", \"amount\": 50, \"price\": 2000.00, \"date_of_arrival\": \"2024-04-20\" },\n" +
                "{ \"category\": \"Transmission\", \"amount\": 40, \"price\": 1500.00, \"date_of_arrival\": \"2024-04-22\" },\n" +
                "{ \"category\": \"Suspension\", \"amount\": 60, \"price\": 1000.00, \"date_of_arrival\": \"2024-04-19\" },\n" +
                "{ \"category\": \"Brakes\", \"amount\": 70, \"price\": 800.00, \"date_of_arrival\": \"2024-04-21\" },\n" +
                "{ \"category\": \"Tires\", \"amount\": 80, \"price\": 150.00, \"date_of_arrival\": \"2024-04-20\" },\n" +
                "{ \"category\": \"Battery\", \"amount\": 30, \"price\": 300.00, \"date_of_arrival\": \"2024-04-22\" },\n" +
                "{ \"category\": \"Exhaust System\", \"amount\": 25, \"price\": 700.00, \"date_of_arrival\": \"2024-04-19\" },\n" +
                "{ \"category\": \"Fuel Pump\", \"amount\": 35, \"price\": 400.00, \"date_of_arrival\": \"2024-04-21\" },\n" +
                "{ \"category\": \"Air Filter\", \"amount\": 45, \"price\": 50.00, \"date_of_arrival\": \"2024-04-20\" },\n" +
                "{ \"category\": \"Oil Filter\", \"amount\": 55, \"price\": 30.00, \"date_of_arrival\": \"2024-04-22\" }\n" +
                "]}";

        // Parsing JSON
        List<Component> components = parseJson(jsonData);

        // Total amount and average price
        int totalAmount = 0;
        double totalPrice = 0.0;
        for (Component component : components) {
            totalAmount += component.getAmount();
            totalPrice += component.getPrice() * component.getAmount();
        }
        double averagePrice = totalPrice / totalAmount;

        System.out.println("Total amount of supplies: " + totalAmount);
        System.out.println("Average price: " + String.format("%.2f", averagePrice));

        // CSV data
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"Category", "Amount", "Price", "Date of Arrival"}); // Header row
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Component component : components) {
            csvData.add(new String[]{
                    component.getCategory(),
                    String.valueOf(component.getAmount()),
                    String.format("%.2f", component.getPrice()),
                    dateFormat.format(component.getDateOfArrival())
            });
        }

        // CSV data to file
        FileWriter csvWriter = new FileWriter("warehouse_report.csv");
        for (String[] row : csvData) {
            csvWriter.write(String.join(",", row) + "\n");
        }
        csvWriter.close();
    }

    public static List<Component> parseJson(String jsonData) throws ParseException {
        List<Component> components = new ArrayList<>();
        String[] componentArray = jsonData.split("\\},\\s*\\{");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String componentJson : componentArray) {
            Component component = new Component();
            component.setCategory(extractValue(componentJson, "\"category\": \"", "\","));
            component.setAmount(Integer.parseInt(extractValue(componentJson, "\"amount\": ", ",")));
            component.setPrice(Double.parseDouble(extractValue(componentJson, "\"price\": ", ",")));
            component.setDateOfArrival(dateFormat.parse(extractValue(componentJson, "\"date_of_arrival\": \"", "\"")));
            components.add(component);
        }
        return components;
    }

    // Method to extract values from JSON string
    public static String extractValue(String data, String startTag, String endTag) {
        int startIndex = data.indexOf(startTag) + startTag.length();
        if (startIndex < 0) {
            return "";
        }
        int endIndex = data.indexOf(endTag, startIndex);
        if (endIndex < 0) {
            return data.substring(startIndex);
        }
        return data.substring(startIndex, endIndex);
    }
    // Constructor
    public static class Component {

        private String category;
        private int amount;
        private double price;
        private Date dateOfArrival;

        public String getCategory() {
            return category;
        }

        public int getAmount() {
            return amount;
        }

        public double getPrice() {
            return price;
        }

        public Date getDateOfArrival() {
            return dateOfArrival;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setDateOfArrival(Date dateOfArrival) {
            this.dateOfArrival = dateOfArrival;
        }
    }
}