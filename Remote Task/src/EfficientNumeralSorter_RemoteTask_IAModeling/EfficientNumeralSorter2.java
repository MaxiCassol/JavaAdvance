package EfficientNumeralSorter_RemoteTask_IAModeling;

import java.util.*;

public class EfficientNumeralSorter2 {

    private static final Map<String, Integer> NUMERAL_VALUES = new HashMap<>();
    static {
        NUMERAL_VALUES.put("zero", 0);
        NUMERAL_VALUES.put("one", 1);
        NUMERAL_VALUES.put("two", 2);
        NUMERAL_VALUES.put("three", 3);
        NUMERAL_VALUES.put("four", 4);
        NUMERAL_VALUES.put("five", 5);
        NUMERAL_VALUES.put("six", 6);
        NUMERAL_VALUES.put("seven", 7);
        NUMERAL_VALUES.put("eight", 8);
        NUMERAL_VALUES.put("nine", 9);
    }

    public static String sortNumeralsEfficiently(String input) {
        if (input == null || input.isEmpty()) {
            return ""; // Return empty string if input is null or empty
        }

        String[] words = input.split(" ");
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();

        // Separate even and odd numbers
        for (String word : words) {
            int value = NUMERAL_VALUES.getOrDefault(word, -1);
            if (value == -1) {
                // If the word is not in the NUMERAL_VALUES map, try parsing it as a number
                try {
                    value = Integer.parseInt(word);
                } catch (NumberFormatException e) {
                    // Ignore non-numeric words
                    continue;
                }
            }
            if (value % 2 == 0) {
                evenNumbers.add(word);
            } else {
                oddNumbers.add(word);
            }
        }

        // Sort even and odd numbers separately
        evenNumbers.sort(Comparator.comparingInt(w -> {
            int value = NUMERAL_VALUES.getOrDefault(w, -1);
            if (value == -1) {
                return Integer.parseInt(w);
            }
            return value;
        }));
        oddNumbers.sort(Comparator.comparingInt(w -> {
            int value = NUMERAL_VALUES.getOrDefault(w, -1);
            if (value == -1) {
                return Integer.parseInt(w);
            }
            return value;
        }));

        // Concatenate even and odd numbers
        List<String> sortedNumbers = new ArrayList<>(evenNumbers);
        sortedNumbers.addAll(oddNumbers);

        // Output sorted arrays with descriptive message
        return "Here are the array sorted by even numbers and odd numbers: " + String.join(" ", sortedNumbers);
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "five 0 two nine eight";
        String test2 = "1 three four seven 6";

        System.out.println("Input: " + test1);
        System.out.println("Sorted: " + sortNumeralsEfficiently(test1));

        System.out.println("\nInput: " + test2);
        System.out.println("Sorted: " + sortNumeralsEfficiently(test2));
    }
}
