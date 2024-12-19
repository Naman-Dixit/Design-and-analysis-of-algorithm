import java.util.Scanner;

public class KnapsackBacktracking {
    static int knapsack(int[] weights, int[] values, int n, int capacity) {
        return knapsackHelper(weights, values, n, capacity, 0);
    }

    static int knapsackHelper(int[] weights, int[] values, int n, int capacity, int currentValue) {
        // Base case: no items left or capacity exhausted
        if (n == 0 || capacity == 0) {
            return currentValue;
        }

        // Exclude the current item
        int exclude = knapsackHelper(weights, values, n - 1, capacity, currentValue);

        // Include the current item if weight allows
        int include = 0;
        if (weights[n - 1] <= capacity) {
            include = knapsackHelper(weights, values, n - 1, capacity - weights[n - 1], currentValue + values[n - 1]);
        }

        // Return the maximum value from including or excluding the current item
        return Math.max(exclude, include);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        System.out.println("Enter the values of the items: ");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        System.out.println("Enter the weights of the items: ");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();

        System.out.println("Maximum value (Backtracking): " + knapsack(values, weights, n, capacity));
    }
}
