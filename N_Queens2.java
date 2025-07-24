/**
 * Problem: N-Queens II (52)
 * Problem: Count the number of distinct solutions to the n-queens puzzle.
 * 
 * Time Complexity: O(N!), where N is the size of the board.
 * Space Complexity: O(N^2) for the board representation.
 */

class Solution {

    // Global variable to keep track of valid board configurations
    int count = 0;

    public int totalNQueens(int n) {
        count = 0; // Reset count for each call

        // Base cases
        if (n == 0 || n == 1) return n;

        // Initialize the chess board with 'x' denoting empty cells
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // Start placing queens from the first row
        nQueens(board, 0);

        return count;
    }

    //Recursive backtracking function to place queens row by row.
    public void nQueens(char[][] board, int row) {
        // All queens are placed successfully
        if (row == board.length) {
            count++;
            return;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';           // Place the queen
                nQueens(board, row + 1);         // Recurse to next row
                board[row][col] = 'x';           // Backtrack
            }
        }
    }

    // Helper function to check whether placing a queen at (row, col) is safe.
    public boolean isSafe(char[][] board, int row, int col) {
        // Check vertically upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true; // It's safe to place the queen
    }
}