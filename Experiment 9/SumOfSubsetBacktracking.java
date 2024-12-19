import java.util.*;

public class SumOfSubsetBacktracking {
    static boolean isSubsetSum(int[] set, int n, int sum) {
        // Base case: if sum becomes 0, return true
        if (sum == 0) return true;
        // If no items are left or sum becomes negative
        if (n == 0 || sum < 0) return false;

        // Include the current element and check for the remaining sum
        if (set[n - 1] <= sum) {
            if (isSubsetSum(set, n - 1, sum - set[n - 1])) return true;
        }
        
        // Exclude the current element and check for the remaining sum
        return isSubsetSum(set, n - 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the set: ");
        int n = sc.nextInt();
        
        int[] set = new int[n];
        System.out.println("Enter the elements of the set:");
        for (int i = 0; i < n; i++) {
            set[i] = sc.nextInt();
        }
        
        System.out.print("Enter the target sum: ");
        int sum = sc.nextInt();
        
        if (isSubsetSum(set, n, sum)) {
            System.out.println("A subset with the given sum exists.");
        } else {
            System.out.println("No subset with the given sum exists.");
        }
    }
}
