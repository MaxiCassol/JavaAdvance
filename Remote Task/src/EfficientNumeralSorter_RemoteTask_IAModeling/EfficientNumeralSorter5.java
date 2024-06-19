package EfficientNumeralSorter_RemoteTask_IAModeling;

import java.util.*;

public class EfficientNumeralSorter5 {

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

        input = input.toLowerCase(); // Convert input to lowercase

        String[] words = input.split(" ");
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> unrecognizedWords = new ArrayList<>();

        // Separate even and odd numbers, and unrecognized words
        for (String word : words) {
            int value = NUMERAL_VALUES.getOrDefault(word, -1);
            if (value == -1) {
                // If the word is not in the NUMERAL_VALUES map, try parsing it as a number
                try {
                    value = Integer.parseInt(word);
                } catch (NumberFormatException e) {
                    // If parsing fails, add the word to unrecognizedWords list
                    unrecognizedWords.add(word);
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

        // Construct the output string
        StringBuilder output = new StringBuilder();
        output.append("Sorted by even numbers and odd numbers: ");
        output.append(String.join(" ", evenNumbers));
        output.append(" - ");
        output.append(String.join(" ", oddNumbers));

        // Add unrecognized words to the output string
        if (!unrecognizedWords.isEmpty()) {
            output.append("\nUnrecognized words: ");
            output.append(String.join(" ", unrecognizedWords));
        }

        return output.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "Five 0 Two nine eight";
        String test2 = "1 Three four Seven 6 Pablito se quedo sin clavos";

        System.out.println("Input: \n" + test1);
        System.out.println("Output: \n" + sortNumeralsEfficiently(test1));

        System.out.println("\nInput: \n" + test2);
        System.out.println("Output: \n" + sortNumeralsEfficiently(test2));
    }
}
