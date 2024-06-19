package Reviews;

import java.util.Scanner;

public class a {

    // Method to calculate total revenue

    public static double calculateTotalRevenue(SalesAssociate[] associates, BonusCalculator bonusCalculator) {

        double totalRevenue = 0.0;

        // Iterate through each sales associate

        for (SalesAssociate associate : associates) {

            // Validate sales, tenure, and performance metrics

            if (associate.getTotalSales() < 0 || associate.getTenure() < 0 || associate.getCustomerRating() < 0 || associate.getProductReturns() < 0) {

                throw new IllegalArgumentException("Invalid sales, tenure, or performance metrics for an associate.");

            }

            // Determine sales target and performance metrics based on position

            double salesTarget = (associate.getPosition() == Position.MANAGER) ? BonusCalculator.MANAGER_TARGET : BonusCalculator.REPRESENTATIVE_TARGET;

            // Calculate bonus amount using the bonus calculator

            double bonus = bonusCalculator.calculateBonus(associate.getTotalSales(), associate.getTenure(), associate.getCustomerRating(), associate.getProductReturns(), salesTarget);

            // Calculate total revenue for the associate

            double totalAssociateRevenue = associate.getTotalSales() + bonus;

            // Add to total revenue

            totalRevenue += totalAssociateRevenue;

        }

        return totalRevenue;

    }

    public static void main(String[] args) {

        // Create array of sales associates

        SalesAssociate[] associates = {

                new SalesAssociate(5000.0, 2, 4.5, 2, Position.REPRESENTATIVE),

                new SalesAssociate(7000.0, 5, 4.8, 1, Position.MANAGER),

                new SalesAssociate(10000.0, 10, 4.0, 3, Position.REPRESENTATIVE)

        };

        // Define bonus calculator strategy

        BonusCalculator bonusCalculator = (sales, tenure, customerRating, productReturns, salesTarget) -> {

            // Define weights for performance metrics

            final double CUSTOMER_RATING_WEIGHT = 0.6;

            final double PRODUCT_RETURNS_WEIGHT = 0.4;

            double bonusRate = 0.05 + (tenure * 0.01); // Base rate plus additional rate based on tenure



            // Calculate weighted average of performance metrics

            double weightedRating = customerRating * CUSTOMER_RATING_WEIGHT;

            double weightedReturns = (5 - productReturns) * PRODUCT_RETURNS_WEIGHT; // Invert product returns for better scores



            // Calculate total weighted performance score

            double totalWeightedScore = weightedRating + weightedReturns;



            if (totalWeightedScore >= 4.5) {

                bonusRate += 0.02; // Additional bonus for high weighted score

            }



            if (sales > salesTarget) {

                return bonusRate * sales;

            }

            return 0.0;

        };

        try {

            // Calculate and display total revenue

            double totalRevenue = calculateTotalRevenue(associates, bonusCalculator);

            System.out.println("Total Revenue: $" + totalRevenue);

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }
        int decimalValue = Integer.parseInt("10110", 2);  // Converts binary "10110" to decimal 22
        int hexValue = Integer.parseInt("7B", 16);       // Converts hexadecimal "7B" to decimal 123
        Scanner scanner = new Scanner("1001"); // String is binary
        System.out.println(scanner.radix()); // Outputs 2
        int number = 123;
        String binaryString = Integer.toString(number, 2);
        String hexString = Long.toString(number, 16);

    }

}

class SalesAssociate {

    private double totalSales;

    private int tenure;

    private double customerRating;

    private int productReturns;

    private Position position;

    // Constructor

    public SalesAssociate(double sales, int tenure, double customerRating, int productReturns, Position position) {

        this.totalSales = sales;

        this.tenure = tenure;

        this.customerRating = customerRating;

        this.productReturns = productReturns;

        this.position = position;

    }

    // Getter methods

    public double getTotalSales() {

        return totalSales;

    }

    public int getTenure() {

        return tenure;

    }

    public double getCustomerRating() {

        return customerRating;

    }

    public int getProductReturns() {

        return productReturns;

    }

    public Position getPosition() {

        return position;

    }

}

enum Position {

    REPRESENTATIVE,

    MANAGER

}

interface BonusCalculator {

    double REPRESENTATIVE_TARGET = 8000.0;

    double MANAGER_TARGET = 10000.0;

    double calculateBonus(double sales, int tenure, double customerRating, int productReturns, double salesTarget);

}