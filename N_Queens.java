/* Problem: https://leetcode.com/problems/n-queens/
 *
 * Time Complexity: O(N!) 
 * - The algorithm tries to place queens row by row.
 * - For each row, it tries up to N columns, and checks for safety in O(N).
 * 
 * Space Complexity: O(N^2)
 * - The board stores N*N characters.
 * - The recursion stack can go up to N levels.
 */

import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        
        // Initialize the board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start solving from the first row
        nQueens(output, board, 0);
        return output;
    }

    /**
     * Backtracking function to place queens row by row
     *  output - stores all valid board configurations
     *  board - current state of the chess board
     *  row - current row to try placing a queen
     */
    public void nQueens(List<List<String>> output, char[][] board, int row) {
        // All queens placed successfully
        if (row == board.length) {
            List<String> ans = new ArrayList<>();
            for (char[] rowVal : board) {
                ans.add(new String(rowVal));
            }
            output.add(ans);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // place queen
                nQueens(output, board, row + 1); // solve for next row
                board[row][col] = '.'; // backtrack
            }
        }
    }

    /**
     * Check if it's safe to place a queen at board[row][col]
     */
    public boolean isSafe(char[][] board, int row, int col) {
        // Check vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}