package ClaimsManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Claim2 {
    private int id;
    private String clientName;
    private double amount;
    private String claimText;
    private String date;

    public Claim2(int id, String clientName, double amount, String claimText, String date) {
        this.id = id;
        this.clientName = clientName;
        this.amount = amount;
        this.claimText = claimText;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public double getAmount() {
        return amount;
    }

    public String getClaimText() {
        return claimText;
    }

    public String getDate() {
        return date;
    }

    // Parse date string to Date object with error handling
    public Date parseDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        return dateFormat.parse(date);
    }
}

public class ClaimManager2 {
    private static Map<String, List<String>> categoryKeywords = new HashMap<>();

    static {
        categoryKeywords.put("quality_issue", Arrays.asList("quality", "defective", "damaged"));
        categoryKeywords.put("size_issue", Arrays.asList("size", "fit", "too small", "too large"));
        categoryKeywords.put("wrong_item", Arrays.asList("wrong item", "incorrect item"));
        categoryKeywords.put("late_delivery", Arrays.asList("late delivery", "delay", "long time"));
        categoryKeywords.put("incorrect_pricing", Arrays.asList("pricing", "price", "cost", "charge"));
        categoryKeywords.put("packaging_problem", Arrays.asList("packaging", "poorly packaged", "broken upon arrival"));
        categoryKeywords.put("other", new ArrayList<>());
    }

    public static Map<String, List<Claim>> categorizeClaims(List<Claim> claims) {
        Map<String, List<Claim>> categorizedClaims = new TreeMap<>();
        for (String category : categoryKeywords.keySet()) {
            categorizedClaims.put(category, new ArrayList<>());
        }

        for (Claim claim : claims) {
            boolean matched = false;
            for (Map.Entry<String, List<String>> entry : categoryKeywords.entrySet()) {
                for (String keyword : entry.getValue()) {
                    if (claim.getClaimText().toLowerCase().contains(keyword)) {
                        categorizedClaims.get(entry.getKey()).add(claim);
                        matched = true;
                        break;
                    }
                }
                if (matched) break;
            }
            if (!matched) {
                categorizedClaims.get("other").add(claim);
            }
        }

        // Sort claims within each category by date
        for (List<Claim> categoryClaims : categorizedClaims.values()) {
            categoryClaims.sort(Comparator.comparing(Claim::getDate));
        }

        return categorizedClaims;
    }

    public static void main(String[] args) {
        // Sample claims
        List<Claim> claims = Arrays.asList(
                new Claim(1, "John Doe", 500, "I purchased a set of decorative vases from your store last week, but one of them arrived damaged. There was a large crack on the side, making it unsuitable for display. I would like a replacement or a refund for this item.", "2024-03-25"),
                new Claim(2, "Jane Smith", 200, "I ordered a wall hanging decoration online, but when the package arrived, one of the items was missing. The invoice indicated that all items were included, but the package only contained three out of the four items. I would like the missing item to be sent to me as soon as possible.", "2024-03-11"),
                new Claim(3, "Michael Johnson", 300, "I recently purchased a decorative mirror from your store, but I'm disappointed with the quality. The frame is flimsy, and the mirror itself has several scratches on the surface. This doesn't meet the quality standards I expected. I request a full refund for this item.", "2024-03-04"),
                new Claim(4, "Emily Brown", 150, "I ordered a set of decorative pillows online, but what I received was not what I ordered. Instead of the floral pattern pillows I selected, I received plain-colored ones. This is not what I expected, and I would like to exchange them for the correct items.", "2024-03-13"),
                new Claim(5, "David Wilson", 100, "I placed an order for a decorative lampshade last week, with the expectation that it would arrive within 3-5 business days. However, it has been over a week, and I have yet to receive the item. This delay has caused inconvenience, and I request compensation for the late delivery.", "2024-03-15"),
                new Claim(6, "Sarah Martinez", 400, "I visited your store yesterday and purchased a decorative wall clock, which was labeled at $50. However, when I checked my receipt, I noticed that I was charged $70 for the item. This discrepancy in pricing is unacceptable, and I demand a refund of the overcharged amount.", "2024-03-18"),
                new Claim(7, "James Taylor", 250, "I bought a decorative table centerpiece from your store, but upon assembling it, I noticed that one of the components was defective. The base of the centerpiece was cracked, making it unstable to hold decorations. I request a replacement for this defective product.", "2024-03-23"),
                new Claim(8, "Emma Harris", 180, "I ordered a decorative throw blanket in a light blue color, but what I received was a darker shade of blue. The color does not match the decor of my living room as I intended. I would like to return this item and receive the correct color as specified in my order.", "2024-03-12"),
                new Claim(9, "Oliver Clark", 120, "I recently ordered a set of decorative candles from your online store, but when they arrived, I found that they were poorly packaged. The candles were loose inside the box, and one of them was broken upon arrival. I request a replacement for the damaged candle and better packaging for future orders.", "2024-03-19"),
                new Claim(10, "Sophia King", 220, "I purchased a decorative area rug from your store, but upon unrolling it, I realized that the size was not as described on the website. The rug is significantly smaller than what was advertised, and it doesn't fit the intended space in my living room. I request a refund for this item.", "2024-03-20"),
                new Claim(11, "Robert White", 130, "I ordered a decorative vase from your store, but the item never arrived. It's been over two weeks since I placed the order, and there's no sign of the package. I demand a full refund for this undelivered item.", "2024-03-29")
        );

        // Categorize claims with error handling
            Map<String, List<Claim>> categorizedClaims = categorizeClaims(claims);

            // Print categorized claims
            for (Map.Entry<String, List<Claim>> entry : categorizedClaims.entrySet()) {
                System.out.println(entry.getKey() + " claims:");
                for (Claim claim : entry.getValue()) {
                    System.out.println("Claim ID: " + claim.getId() + ", Date: " + claim.getDate());
                }
                System.out.println();
            }
    }
}
