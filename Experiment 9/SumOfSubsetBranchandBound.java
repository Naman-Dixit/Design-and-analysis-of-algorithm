import java.util.*;

class SumOfSubsetBranchAndBound {
    static class Node {
        int level, sum;
        boolean[] included;

        Node(int level, int sum, boolean[] included) {
            this.level = level;
            this.sum = sum;
            this.included = included.clone();
        }
    }

    static boolean isSubsetSum(int[] set, int n, int sum) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] included = new boolean[n];
        queue.add(new Node(-1, 0, included));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int level = current.level;
            int currentSum = current.sum;

            if (currentSum == sum) {
                return true;
            }

            if (level < n - 1) {
                // Include the next element
                boolean[] includedNew = current.included.clone();
                includedNew[level + 1] = true;
                if (currentSum + set[level + 1] <= sum) {
                    queue.add(new Node(level + 1, currentSum + set[level + 1], includedNew));
                }

                // Exclude the next element
                includedNew = current.included.clone();
                queue.add(new Node(level + 1, currentSum, includedNew));
            }
        }
        return false;
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
