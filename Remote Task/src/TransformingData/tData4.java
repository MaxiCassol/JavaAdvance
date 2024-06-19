package TransformingData;

public class tData4 {

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
        Object[] originalArray = {'A', 'B', 1, 2, 'C'};

        // Print the original array
        System.out.println("Original Array:");
        for (Object obj : originalArray) {
            System.out.print(obj + " ");
        }
        System.out.println(); // Print a newline after the original array

        // Define the transformation function
        Transformer<Object> transformer = input -> {
            if (input instanceof Character) {
                // If input is a character
                char letter = (char) input;
                // Convert the letter to lowercase and find its corresponding index
                int index = Character.toLowerCase(letter) - 'a';
                // Double the index and add 1 for letters
                index = index * 2 + 5;
                // Convert the new index back to a character
                return (char) ('a' + index);
            } else if (input instanceof Number) {
                // If input is a number, double it and add 5, then cast to integer
                return (int) (((Number) input).doubleValue() * 2 + 5);
            }
            return input; // If neither a letter nor a number, return the input as is
        };

        // Transform the original array using the specified transformation function
        Object[] transformedArray = transformData(originalArray, transformer);

        // Print the transformed array
        System.out.println("Transformed Array:");
        for (Object obj : transformedArray) {
            System.out.print(obj + " ");
        }
    }
}
