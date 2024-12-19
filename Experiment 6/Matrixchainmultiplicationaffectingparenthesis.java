
import java.util.Scanner;

public class MatrixChainMultiplicationWithParenthesis {

    // Function to find the minimum cost and store the optimal parenthesis positions
    public static void matrixChainOrder(int[] dimensions, int n) {
        int[][] dp = new int[n][n]; // dp[i][j] represents the minimum cost of multiplying matrices i through j
        int[][] split = new int[n][n]; // split[i][j] stores the position of the split for optimal cost

        // Initialize the cost for multiplying a single matrix as 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // l is the chain length
        for (int l = 2; l < n; l++) { // l starts from 2 because we need at least two matrices to multiply
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1; // Ending index of the chain
                dp[i][j] = Integer.MAX_VALUE;

                // Calculate the minimum cost for splitting the chain at k
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k; // Store the split position
                    }
                }
            }
        }

        // Print the minimum cost
        System.out.println("Minimum number of scalar multiplications: " + dp[1][n - 1]);

        // Print the optimal parenthesis positioning
        System.out.print("Optimal Parenthesis Positioning: ");
        printOptimalParenthesis(split, 1, n - 1);
        System.out.println();
    }

    // Recursive function to print the optimal parenthesis positioning
    private static void printOptimalParenthesis(int[][] split, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }
        System.out.print("(");
        printOptimalParenthesis(split, i, split[i][j]); // Left sub-chain
        printOptimalParenthesis(split, split[i][j] + 1, j); // Right sub-chain
        System.out.print(")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of matrices
        System.out.print("Enter the number of matrices: ");
        int numMatrices = scanner.nextInt();

        // Input dimensions
        int[] dimensions = new int[numMatrices + 1];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i <= numMatrices; i++) {
            System.out.print("Dimension " + (i + 1) + ": ");
            dimensions[i] = scanner.nextInt();
        }

        // Calculate the minimum cost and print the parenthesis positioning
        matrixChainOrder(dimensions, dimensions.length);

        scanner.close();
    }
}

/*

Here is the **Matrix Chain Multiplication Problem** solved using Dynamic Programming with the ability to track the parenthesis positioning.

### **Code**

```java
import java.util.Scanner;

public class MatrixChainMultiplicationWithParenthesis {

    // Function to find the minimum cost and store the optimal parenthesis positions
    public static void matrixChainOrder(int[] dimensions, int n) {
        int[][] dp = new int[n][n]; // dp[i][j] represents the minimum cost of multiplying matrices i through j
        int[][] split = new int[n][n]; // split[i][j] stores the position of the split for optimal cost

        // Initialize the cost for multiplying a single matrix as 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // l is the chain length
        for (int l = 2; l < n; l++) { // l starts from 2 because we need at least two matrices to multiply
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1; // Ending index of the chain
                dp[i][j] = Integer.MAX_VALUE;

                // Calculate the minimum cost for splitting the chain at k
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k; // Store the split position
                    }
                }
            }
        }

        // Print the minimum cost
        System.out.println("Minimum number of scalar multiplications: " + dp[1][n - 1]);

        // Print the optimal parenthesis positioning
        System.out.print("Optimal Parenthesis Positioning: ");
        printOptimalParenthesis(split, 1, n - 1);
        System.out.println();
    }

    // Recursive function to print the optimal parenthesis positioning
    private static void printOptimalParenthesis(int[][] split, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }
        System.out.print("(");
        printOptimalParenthesis(split, i, split[i][j]); // Left sub-chain
        printOptimalParenthesis(split, split[i][j] + 1, j); // Right sub-chain
        System.out.print(")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of matrices
        System.out.print("Enter the number of matrices: ");
        int numMatrices = scanner.nextInt();

        // Input dimensions
        int[] dimensions = new int[numMatrices + 1];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i <= numMatrices; i++) {
            System.out.print("Dimension " + (i + 1) + ": ");
            dimensions[i] = scanner.nextInt();
        }

        // Calculate the minimum cost and print the parenthesis positioning
        matrixChainOrder(dimensions, dimensions.length);

        scanner.close();
    }
}
```

---

### **Explanation**

1. **Dynamic Programming Table (`dp`)**:
   - `dp[i][j]` stores the minimum cost of multiplying matrices \( A_i \) through \( A_j \).

2. **Parenthesis Tracking Table (`split`)**:
   - `split[i][j]` stores the optimal index \( k \) at which the chain is split to achieve the minimum cost.

3. **Recursive Function (`printOptimalParenthesis`)**:
   - Recursively prints the parenthesis placement based on the `split` table.

---

### **Example Run**

#### Input:
```
Enter the number of matrices: 3
Enter the dimensions of the matrices:
Dimension 1: 10
Dimension 2: 20
Dimension 3: 30
Dimension 4: 40
```

#### Output:
```
Minimum number of scalar multiplications: 18000
Optimal Parenthesis Positioning: ((A1A2)A3)
```

#### Explanation:
- \( A1 (10 \times 20) \), \( A2 (20 \times 30) \), \( A3 (30 \times 40) \)
- Split at \( k = 2 \), giving:
  - Left: \( (A1A2) \)
  - Right: \( (A3) \)
  - Total Cost = \( 10 \times 20 \times 30 + 10 \times 30 \times 40 = 18000 \).

---

### **Time and Space Complexity**

#### **Time Complexity**:
- \( O(n^3) \): The algorithm uses three nested loops:
  - Outer loop for chain length \( l \): \( O(n) \)
  - Middle loop for starting index \( i \): \( O(n) \)
  - Inner loop for split position \( k \): \( O(n) \)

#### **Space Complexity**:
- \( O(n^2) \): Two 2D tables (`dp` and `split`) of size \( n \times n \).

This implementation efficiently calculates the optimal parenthesis positioning along with the minimum multiplication cost.

 /*

  */
