import java.util.*;

public class KnapsackGreedyUserInput {
    static class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static double knapsackGreedy(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double maxValue = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                break; // Cannot include any more items
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];
        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();

        double maxValue = knapsackGreedy(items, capacity);
        System.out.println("Maximum value (Greedy): " + maxValue);
    }
}
/*
 
Greedy Approach
Algorithm
The greedy approach uses a value-to-weight ratio to make decisions:

Calculate Ratios:

For each item, calculate 
value-to-weight ratio
=
value
weight
value-to-weight ratio= 
weight
value
​
 .
Sort Items:

Sort the items in descending order of their value-to-weight ratio.
Pick Items:

Traverse the sorted items and pick items until the knapsack is full or no more items can be added.
Limitation: The greedy approach works optimally for fractional knapsack problems but may give suboptimal solutions for the 0/1 knapsack.



 */
