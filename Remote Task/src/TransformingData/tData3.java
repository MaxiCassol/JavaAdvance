package TransformingData;

import java.util.function.Function;

public class tData3 {

    // Define a common interface for the transformation function
    interface Transformer<T> {
        T apply(T input);
    }

    // Modify the transformData function to accept the new type of transformation function
    public static <T> T[] transformData(T[] arr, Transformer<T> transformer) {
        T[] transformedArray = arr.clone(); // Create a copy of the original array

        // Loop through each element of the input array
        for (int i = 0; i < arr.length; i++) {
            // Apply the transformation function to the element
            transformedArray[i] = transformer.apply(arr[i]);
        }

        return transformedArray;
    }

    public static void main(String[] args) {
        // Original array (character array)
        Character[] originalArray = {'A', 'B', 'C', 'D', 'E'};

        // Print the original array
        System.out.println("Original Array:");
        for (char letter : originalArray) {
            System.out.print(letter + " ");
        }
        System.out.println(); // Print a newline after the original array

        // Define the transformation function
        Transformer<Character> transformer = letter -> {
            // If the input is a character, convert it to its corresponding index
            // Double the index and add 1 for the new index
            int newIndex = (Character.toLowerCase(letter) - 'a') * 2 + 5;
            // Convert the new index back to a character
            return (char) ('a' + newIndex);
        };

        // Transform the original array using the specified transformation function
        Character[] transformedArray = transformData(originalArray, transformer);

        // Print the transformed array
        System.out.println("Transformed Array:");
        for (char letter : transformedArray) {
            System.out.print(letter + " ");
        }
    }
}
