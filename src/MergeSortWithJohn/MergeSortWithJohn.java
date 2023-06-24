package MergeSortWithJohn;

import java.util.Random;

// https://www.youtube.com/watch?v=bOk35XmHPKs (Merge Sort Algorithm in Java - Full Tutorial with Source)
// O(n log n)
public class MergeSortWithJohn {

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {  // Helper method
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;  // left, right, inputArray
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] < rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;  // Move pointer in inputArray (= merged array)
        }

        // Handling when the left or right arrays have been exhausted (already put into inputArray)
        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
    }

    private static void mergeSort(int[] inputArray) {  // Main mergeSort
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];  // In case inputLength is an odd number

        // Fill up leftHalf array and rightHalf array
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];  // want to start filling up rightHalf at index 0 E.g. 5-5=0 -> 6-5=1 -> 7-5=2
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge two sorted arrays
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        Random randomNumber = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {  // Filling up an int array with 10 random numbers
            numbers[i] = randomNumber.nextInt(1000000);
        }

        System.out.println("Before merge sort:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nAfter merge sort:");
        printArray(numbers);
    }
}
