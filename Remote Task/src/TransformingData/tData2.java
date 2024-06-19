package TransformingData;
import java.util.function.IntUnaryOperator;

public class tData2 {

    public static int[] transformData(int[] arr, IntUnaryOperator transformer) {
        int[] transformedArray = new int[arr.length];

        // Loop through each element of the input array
        for (int i = 0; i < arr.length; i++) {
            // Apply the transformation function to the element
            transformedArray[i] = transformer.applyAsInt(arr[i]);
        }

        return transformedArray;
    }

    public static void main(String[] args) {
        // Original array
        int[] originalArray = {1, 2, 3, 4, 5};

        // Print the original array
        System.out.println("Original Array:");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
        System.out.println(); // Print a newline after the original array

        // Define the transformation function (double and add 5)
        IntUnaryOperator transformer = num -> num * 2 + 5;

        // Transform the original array using the specified transformation function
        int[] transformedArray = transformData(originalArray, transformer);

        // Print the transformed array
        System.out.println("Transformed Array:");
        for (int num : transformedArray) {
            System.out.print(num + " ");
        }
    }
}
