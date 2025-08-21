import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Three arrays to keep track of occupied columns and diagonals
        boolean[] col = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n - 1]; // row - col + (n-1) to map to index 0 to 2n-2
        boolean[] antiDiag = new boolean[2 * n - 1]; // row + col

        solve(0, n, board, col, mainDiag, antiDiag, result);
        return result;
    }

    private void solve(int row, int n, char[][] board, boolean[] col, boolean[] mainDiag, boolean[] antiDiag, List<List<String>> result) {
        // Base case: All queens have been placed successfully
        if (row == n) {
            result.add(createBoard(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int j = 0; j < n; j++) {
            // Check if the current position is safe
            if (!col[j] && !mainDiag[row - j + n - 1] && !antiDiag[row + j]) {
                // Place the queen
                board[row][j] = 'Q';
                col[j] = true;
                mainDiag[row - j + n - 1] = true;
                antiDiag[row + j] = true;

                // Recurse to the next row
                solve(row + 1, n, board, col, mainDiag, antiDiag, result);

                // Backtrack: remove the queen and reset the visited flags
                board[row][j] = '.';
                col[j] = false;
                mainDiag[row - j + n - 1] = false;
                antiDiag[row + j] = false;
            }
        }
    }

    private List<String> createBoard(char[][] board) {
        List<String> currentBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            currentBoard.add(new String(board[i]));
        }
        return currentBoard;
    }
}