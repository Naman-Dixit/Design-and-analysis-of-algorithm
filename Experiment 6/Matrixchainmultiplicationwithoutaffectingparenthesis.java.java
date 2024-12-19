
import java.util.Scanner;

public class MatrixChainMultiplication {

    // Function to find the minimum cost of matrix chain multiplication
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n]; // dp[i][j] represents the minimum cost of multiplying matrices i through j

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
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // The result is stored in dp[1][n-1]
        return dp[1][n - 1];
    }

    // Main method to take user input and test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of matrices
        System.out.print("Enter the number of matrices: ");
        int numMatrices = scanner.nextInt();

        // Input for the dimensions array
        int[] dimensions = new int[numMatrices + 1];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i <= numMatrices; i++) {
            System.out.print("Dimension " + i + ": ");
            dimensions[i] = scanner.nextInt();
        }

        // Calculating and displaying the minimum number of scalar multiplications
        int result = matrixChainOrder(dimensions);
        System.out.println("Minimum number of scalar multiplications: " + result);
    }
}

/*
 
### **Explanation of the Code**

#### **Objective**
The goal of the **Matrix Chain Multiplication** problem is to find the most efficient way to multiply a sequence of matrices. The problem minimizes the number of scalar multiplications while preserving the order of the matrices.

---

### **Algorithm**

1. **Input**:
   - The user inputs the number of matrices \( n \).
   - The dimensions of the matrices are provided as an array `dimensions` such that:
     - The \( i^{th} \) matrix has dimensions \( dimensions[i-1] \times dimensions[i] \).

2. **Initialization**:
   - Create a 2D array `dp[n][n]` where `dp[i][j]` stores the minimum number of scalar multiplications required to multiply matrices from \( A_i \) to \( A_j \).
   - Set `dp[i][i] = 0` because a single matrix requires no multiplications.

3. **Iterative DP Calculation**:
   - Use a bottom-up approach with increasing chain lengths \( l \), starting from 2.
   - For each chain length \( l \), calculate the minimum multiplication cost for all possible subproblems of that length.

4. **Recursive Relation**:
   - To calculate `dp[i][j]`, try splitting the chain between \( k \) (where \( i \leq k < j \)):
     \[
     dp[i][j] = \min_{i \leq k < j} \big(dp[i][k] + dp[k+1][j] + dimensions[i-1] \cdot dimensions[k] \cdot dimensions[j]\big)
     \]

5. **Output**:
   - The final result is stored in `dp[1][n-1]`, representing the minimum cost of multiplying all matrices.

---

### **Code Walkthrough**

1. **User Input**:
   - The user specifies the number of matrices and their dimensions.

2. **Dynamic Programming Table Setup**:
   - `dp[i][j]` is initialized to 0 for single matrices (\( i == j \)).

3. **Iterative Computation**:
   - The chain length \( l \) determines the size of the matrix groups being multiplied.
   - For each chain length, calculate the cost for every possible sub-chain of that length.

4. **Recursive Cost Calculation**:
   - For each sub-chain, iterate through all possible split points \( k \) to find the minimum cost.

5. **Result**:
   - The result, `dp[1][n-1]`, is printed as the minimum cost for the full chain multiplication.

---

### **Example Input and Output**

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
```

#### Explanation:
- For matrices \( A1 (10 \times 20) \), \( A2 (20 \times 30) \), \( A3 (30 \times 40) \):
  - Splitting at \( k = 1 \): Cost = \( 10 \cdot 20 \cdot 30 \) = 6000
  - Splitting at \( k = 2 \): Cost = \( 20 \cdot 30 \cdot 40 \) = 24000
  - Adding costs = \( 6000 + 24000 = 18000 \).

---

### **Time Complexity**

The time complexity is \( O(n^3) \), where \( n \) is the number of matrices. This is because:
1. The algorithm iterates over all possible chain lengths \( l \) (\( O(n) \)).
2. For each chain length, it considers all starting points \( i \) (\( O(n) \)).
3. For each sub-chain, it evaluates all split points \( k \) (\( O(n) \)).

Thus, the nested loops give \( O(n^3) \).

---

### **Space Complexity**

The space complexity is \( O(n^2) \) due to the 2D DP table (`dp`), which stores the cost of multiplying all sub-chains.

---

### **Optimizations**
- **Space Optimization**: Instead of a 2D DP table, we can use a 1D array and process subproblems iteratively to reduce space usage.
- **Recursive Memoization**: A recursive approach with memoization can reduce redundant computations.

This code effectively calculates the minimum cost using a bottom-up DP approach, which is efficient and widely applicable for such optimization problems.

 */
