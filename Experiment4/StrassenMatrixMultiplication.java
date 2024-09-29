    import java.util.Scanner;

public class StrassenMatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrices (must be a power of 2): ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        System.out.println("Enter matrix A:");
        inputMatrix(A, scanner);

        System.out.println("Enter matrix B:");
        inputMatrix(B, scanner);

        int[][] C = strassenMultiply(A, B, n);

        System.out.println("Resultant matrix C (A * B):");
        printMatrix(C, n);
    }

    // Strassen's matrix multiplication method
    public static int[][] strassenMultiply(int[][] A, int[][] B, int n) {
        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int newSize = n / 2;
        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];
        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];
        int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        // Dividing matrices A and B into 4 sub-matrices
        split(A, A11, 0, 0);
        split(A, A12, 0, newSize);
        split(A, A21, newSize, 0);
        split(A, A22, newSize, newSize);
        split(B, B11, 0, 0);
        split(B, B12, 0, newSize);
        split(B, B21, newSize, 0);
        split(B, B22, newSize, newSize);

        // Strassen's 7 multiplication steps
        int[][] M1 = strassenMultiply(add(A11, A22), add(B11, B22), newSize);
        int[][] M2 = strassenMultiply(add(A21, A22), B11, newSize);
        int[][] M3 = strassenMultiply(A11, subtract(B12, B22), newSize);
        int[][] M4 = strassenMultiply(A22, subtract(B21, B11), newSize);
        int[][] M5 = strassenMultiply(add(A11, A12), B22, newSize);
        int[][] M6 = strassenMultiply(subtract(A21, A11), add(B11, B12), newSize);
        int[][] M7 = strassenMultiply(subtract(A12, A22), add(B21, B22), newSize);

        // Computing final quadrants of result matrix C
        int[][] C11 = add(subtract(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(subtract(add(M1, M3), M2), M6);

        // Combine quadrants into a single result matrix
        int[][] C = new int[n][n];
        join(C11, C, 0, 0);
        join(C12, C, 0, newSize);
        join(C21, C, newSize, 0);
        join(C22, C, newSize, newSize);

        return C;
    }

    // Function to add two matrices
    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    // Function to subtract two matrices
    public static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    // Function to split the matrix into quadrants
    public static void split(int[][] P, int[][] C, int iB, int jB) {
        for (int i = 0, i2 = iB; i < C.length; i++, i2++) {
            for (int j = 0, j2 = jB; j < C.length; j++, j2++) {
                C[i][j] = P[i2][j2];
            }
        }
    }

    // Function to join quadrants into a matrix
    public static void join(int[][] C, int[][] P, int iB, int jB) {
        for (int i = 0, i2 = iB; i < C.length; i++, i2++) {
            for (int j = 0, j2 = jB; j < C.length; j++, j2++) {
                P[i2][j2] = C[i][j];
            }
        }
    }

    // Method to input a matrix
    public static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*Strassen's Algorithm
Method: Strassen’s method reduces the number of multiplicative operations by splitting the matrices into submatrices. It uses 7 multiplications (instead of 8 in the naive method) and 18 additions/subtractions.
Time Complexity:𝑂(𝑛log⁡27)≈𝑂(𝑛2.81), which is asymptotically faster than the naive 𝑂(𝑛3).

Advantages:
Faster for large matrices due to its lower time complexity.
Reduces the number of multiplications, which is often the costliest operation in matrix multiplication.
Disadvantages:
More complex algorithm, involving multiple additions and subtractions.
Overhead from recursive splitting and managing submatrices can make it slower than the naive method for smaller matrices.
Numerical instability and precision errors may occur due to additional floating-point operations.
Performance Comparison
For Small Matrices: The traditional method often outperforms Strassen due to the overhead of recursive submatrix handling in Strassen's algorithm. The additional operations for splitting and combining results may negate the speed advantage for small matrices.

For Large Matrices: Strassen’s method outperforms the traditional method due to its sub-cubic time complexity, which becomes significant as the matrix size grows. For very large matrices, Strassen’s method is much faster in practice.

Practical Considerations: Modern implementations of matrix multiplication, such as those in optimized linear algebra libraries (e.g., BLAS), often rely on highly tuned versions of the traditional method or hybrid approaches that combine both methods depending on matrix size and hardware.

Summary:
Naive Method: Simple, cubic time complexity (𝑂(𝑛3)), good for small matrices.
Strassen’s Method: More complex, faster asymptotically with a time complexity of 𝑂(𝑛2.81), suitable for large matrices but may have more overhead and precision issues.
In real-world applications, the choice depends on the matrix size and specific computational needs. 

Strassen’s Matrix Multiplication:

Space Complexity:𝑂(𝑛2)
(with extra overhead due to recursive calls)
Like the traditional method, Strassen’s algorithm also needs space to store the input matrices 
𝐴
and 
𝐵
B, and the resulting matrix 
𝐶, each of size 𝑛×𝑛, which is 𝑂(𝑛2).

However, Strassen’s method also involves recursive splitting of matrices into submatrices and performing additional calculations. At each recursion level, new temporary matrices (for sums and products) are generated.
The auxiliary space for these temporary matrices increases the space complexity slightly, but in the standard implementation, it remains 
𝑂(𝑛2).

Recursive Overhead: At each recursive level, Strassen's method creates 7 additional matrices for intermediate results, which leads to an extra space overhead.
Total Space: 
𝑂(𝑛2)
 for the input/output matrices, plus some overhead for temporary submatrices. In practice, the space usage is higher than the traditional method, but asymptotically, it's still 
𝑂(𝑛2).*/
