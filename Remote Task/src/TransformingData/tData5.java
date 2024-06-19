package TransformingData;

public class tData5 {

    public static int[] transformData(int[] arr) {
        int[] transformedArray = new int[arr.length];

        // Loop through each element of the input array
        for (int i = 0; i < arr.length; i++) {
            // Double the element and add 5 to it
            transformedArray[i] = arr[i] * 2 + 5;
        }

        return transformedArray;
    }

    public static void main(String[] args) {
        // Test the transformData method
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] transformedArray = transformData(originalArray);

        // Print the transformed array
        System.out.println("Transformed Array:");
        for (int num : transformedArray) {
            System.out.print(num + " ");
        }
    }
}
