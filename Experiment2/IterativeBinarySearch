import java.util.Scanner;
public class BinarySearch {

    // Method to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate mid to avoid overflow

            // Check if target is at mid
            if (arr[mid] == target) {
                return mid;  // Target found
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                high = mid - 1;
            }
        }

        return -1;  // Target not found
    }

    // Main method to accept user input and perform the search
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accepting array size from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize array
        int[] arr = new int[size];

        // Accepting elements of the array from the user
        System.out.println("Enter " + size + " sorted elements (in ascending order):");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Accept the target value to search for
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(arr, target);

        // Output result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        scanner.close();  // Close the scanner
    }
}
/*
Time Complexity:
The time complexity of an iterative binary search is O(log n), where n is the number of elements in the array.

Explanation:
In each iteration, the search space (the portion of the array being considered) is halved.
This halving process continues until the search space becomes empty or the target value is found.
Since the number of elements in the search space is reduced by half with each step, the total number of iterations required is proportional to the logarithm of n to the base 2, i.e., log₂(n).
Thus, the time complexity is O(log n).

Space Complexity:
The space complexity of the iterative binary search is O(1).

Explanation:
The algorithm only uses a few additional variables like low, high, mid, and target.
These variables occupy constant space regardless of the size of the input array.
No additional data structures are used that grow with the input size.
Thus, the space complexity is O(1), or constant space.

Summary:
Time Complexity: O(log n)
Space Complexity: O(1)
*/
