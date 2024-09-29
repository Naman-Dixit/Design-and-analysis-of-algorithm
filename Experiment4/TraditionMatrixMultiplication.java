import java.util.Scanner;

public class TraditionalMatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrices (n x n): ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        System.out.println("Enter matrix A:");
        inputMatrix(A, scanner);

        System.out.println("Enter matrix B:");
        inputMatrix(B, scanner);

        int[][] C = traditionalMultiply(A, B, n);

        System.out.println("Resultant matrix C (A * B):");
        printMatrix(C, n);
    }

    // Traditional matrix multiplication method
    public static int[][] traditionalMultiply(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
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
/*Traditional Matrix Multiplication (Naive Method)
Method: The traditional matrix multiplication involves three nested loops where each 
element of the resulting matrix is the dot product of the corresponding row and column 
from the two matrices.
Time Complexity:
𝑂(𝑛3), where 𝑛
n is the dimension of the matrix (assuming square matrices of size 𝑛×𝑛 

Advantages:
Simple to implement.
Performs well for small matrices.
Disadvantages:
Becomes inefficient for large matrices due to its cubic time complexity.
Traditional Matrix Multiplication: Straightforward with three nested loops,
suitable for smaller matrices.
Traditional Matrix Multiplication:

Space Complexity:𝑂(𝑛2)
In traditional matrix multiplication, you need space to store the two input matrices 
𝐴
A and 𝐵
B, each of size 𝑛×𝑛, and the resulting matrix
𝐶
C of the same size.
No additional auxiliary space is required aside from
the space to store the result, so the space complexity is primarily driven by the
 matrices themselves.
Total Space:𝑂(𝑛2)
 for storing the input and output matrices.*/
