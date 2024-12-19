import java.util.*;

public class KnapsackBranchAndBound {
    static class Node {
        int level;
        int profit;
        int weight;
        float bound;

        Node(int level, int profit, int weight) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
            this.bound = 0;
        }
    }

    static float bound(Node u, int n, int capacity, int[] weights, int[] values) {
        if (u.weight >= capacity) return 0;

        int totalWeight = u.weight;
        float totalValue = u.profit;

        int j = u.level + 1;
        while (j < n && totalWeight + weights[j] <= capacity) {
            totalWeight += weights[j];
            totalValue += values[j];
            j++;
        }

        if (j < n) totalValue += (capacity - totalWeight) * values[j] / (float)weights[j];
        return totalValue;
    }

    static int knapsack(int[] values, int[] weights, int n, int capacity) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(a -> -a.bound));
        Node u = new Node(-1, 0, 0);
        queue.add(u);

        int maxProfit = 0;

        while (!queue.isEmpty()) {
            u = queue.poll();

            if (u.level == n - 1) continue;

            Node v = new Node(u.level + 1, u.profit, u.weight);

            if (v.weight <= capacity && v.profit > maxProfit) {
                maxProfit = v.profit;
            }

            v.bound = bound(v, n, capacity, weights, values);
            if (v.bound > maxProfit) queue.add(v);
        }
        return maxProfit;
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

        System.out.println("Maximum value (Branch and Bound): " + knapsack(values, weights, n, capacity));
    }
}
