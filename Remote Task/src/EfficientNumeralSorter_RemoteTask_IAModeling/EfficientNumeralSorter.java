package EfficientNumeralSorter_RemoteTask_IAModeling;

import java.util.*;

public class EfficientNumeralSorter {

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

        String[] words = input.split(" ");
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();

        // Separate even and odd numbers
        for (String word : words) {
            int value = NUMERAL_VALUES.getOrDefault(word, -1);
            if (value != -1) {
                if (value % 2 == 0) {
                    evenNumbers.add(word);
                } else {
                    oddNumbers.add(word);
                }
            }
        }

        // Sort even and odd numbers separately
        evenNumbers.sort(Comparator.comparingInt(NUMERAL_VALUES::get));
        oddNumbers.sort(Comparator.comparingInt(NUMERAL_VALUES::get));

        // Concatenate even and odd numbers
        List<String> sortedNumbers = new ArrayList<>(evenNumbers);
        sortedNumbers.addAll(oddNumbers);

        // Output sorted arrays with descriptive message
        return "Here is the array sorted by even numbers and odd numbers: " + String.join(" ", sortedNumbers);
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "five zero two nine eight";
        String test2 = "one three four seven six";

        System.out.println("Input: " + test1);
        System.out.println("Output: " + sortNumeralsEfficiently(test1));

        System.out.println("\nInput: " + test2);
        System.out.println("Output: " + sortNumeralsEfficiently(test2));
    }
}
