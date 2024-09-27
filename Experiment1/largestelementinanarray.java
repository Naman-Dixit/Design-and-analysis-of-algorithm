import java.util.Scanner;

public class DAA1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the length of the array
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        // Create an array of the specified length
        int[] numbers = new int[length];

        // Ask the user to input the elements of the array
        System.out.println("Enter " + length + " numbers:");
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Call the method to find the largest number
        int largest = findLargestNumber(numbers);

        // Print the largest number
        System.out.println("The largest number in the array is: " + largest);

        scanner.close();
    }

    // Method to find the largest number in an array
    public static int findLargestNumber(int[] array) {
        // Initialize the largest number with the first element of the array
        int largest = array[0];

        // Loop through the array to find the largest number
        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return largest;
    }
}
// time complexity is O(n)
