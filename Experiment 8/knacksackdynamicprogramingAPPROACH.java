
import java.util.*;

public class KnapsackDPUserInput {

    static int knapsackDP(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];
        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = sc.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();

        int maxValue = knapsackDP(values, weights, capacity);
        System.out.println("Maximum value (DP): " + maxValue);
    }
}
