import java.util.Scanner;

public class RecursiveBinarySearch {

    // Recursive method for binary search
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if target is at mid
            if (arr[mid] == target) {
                return mid;  // Target found
            }

            // If target is smaller, search the left half
            if (arr[mid] > target) {
                return binarySearch(arr, low, mid - 1, target);
            }

            // If target is larger, search the right half
            return binarySearch(arr, mid + 1, high, target);
        }

        return -1;  // Target not found
    }

    // Main method to accept user input and perform the search
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize array
        int[] arr = new int[size];

        // Accept array elements from user
        System.out.println("Enter " + size + " sorted elements (in ascending order):");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Accept target value
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(arr, 0, size - 1, target);

        // Output result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        scanner.close();
    }
}

/*Time Complexity:
The time complexity of the recursive binary search remains O(log n), just like the iterative version.

Why O(log n)?
In each recursive call, the problem size (i.e., the number of elements in the search range) is reduced by half.
Therefore, the number of recursive calls is proportional to log₂(n), where n is the number of elements in the array.
Space Complexity:
The space complexity of the recursive binary search is O(log n) due to the function call stack.

Why O(log n)?
Each recursive call adds a new frame to the call stack.
Since the depth of the recursion is proportional to the number of times the search space is halved, the maximum depth of recursion will be log₂(n).
Therefore, the space complexity is O(log n) due to the recursion stack.
Summary:
Time Complexity: O(log n) (same as the iterative version)
Space Complexity: O(log n) (due to recursion stack) */
