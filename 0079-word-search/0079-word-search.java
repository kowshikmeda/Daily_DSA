class Solution {
    private int m;
    private int n;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.word = word;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        // Base case: If we've found all characters of the word
        if (k == word.length()) {
            return true;
        }

        // Boundary and character mismatch checks
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(k)) {
            return false;
        }

        // Mark the current cell as visited to avoid cycles
        char originalChar = board[i][j];
        board[i][j] = '#';

        // Explore all four possible directions (up, down, left, right)
        boolean found = dfs(i + 1, j, k + 1) ||
                        dfs(i - 1, j, k + 1) ||
                        dfs(i, j + 1, k + 1) ||
                        dfs(i, j - 1, k + 1);

        // Backtrack: Restore the original character of the cell
        board[i][j] = originalChar;

        return found;
    }
}