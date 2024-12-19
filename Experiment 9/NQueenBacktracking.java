public class NQueenBacktracking {
    static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check this column on upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    static boolean solveNQueen(int[][] board, int row, int N) {
        if (row >= N) return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1;
                if (solveNQueen(board, row + 1, N)) return true;
                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 8; // You can change N for a different size
        int[][] board = new int[N][N];
        
        if (solveNQueen(board, 0, N)) {
            System.out.println("Solution found:");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Solution does not exist.");
        }
    }
}
