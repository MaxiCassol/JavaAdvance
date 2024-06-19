package EfficientNumeralSorter_RemoteTask_IAModeling;

import java.util.*;

public class testtt {
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
            return "";
        }
        String[] words = input.split(" ");
        // Check if input can be parsed as an integer
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (isNumeric) {
            // If input is numeric, convert it to an integer array
            int[] numbers = Arrays.stream(words).mapToInt(Integer::parseInt).toArray();
            // Sort the numbers
            Arrays.sort(numbers);
            // Convert the sorted numbers back to string array
            words = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        } else {
            // If input contains numeral words, sort them using the predefined map
            Arrays.sort(words, Comparator.comparingInt(NUMERAL_VALUES::get));
        }
        return String.join(" ", words);
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