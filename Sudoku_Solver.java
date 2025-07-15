/* Problem: https://leetcode.com/problems/sudoku-solver/
 *
 * Time Complexity: O(9^(n*n)) → practically much less due to constraint pruning
 * - Each empty cell has 9 possibilities, and backtracking prunes invalid ones early.
 * 
 * Space Complexity: O(1)
 * - The board is modified in-place. No extra space apart from recursion stack.
 */

class Solution {
    public void solveSudoku(char[][] board) {
        // Start solving from top-left cell
        sudokuSolver(board, 0, 0);
    }

    /**
     * Recursive backtracking function to solve Sudoku
     * 
     *  board - 9x9 Sudoku board with '.' as empty cells
     *  row - current row index
     *  col - current column index
     *  true if the board is solvable from this state
     */
    public boolean sudokuSolver(char[][] board, int row, int col) {
        // Base case: all rows processed
        if (row == 9) return true;

        // Calculate next cell position
        int newRow = row, newCol = col + 1;
        if (col + 1 == 9) {
            newRow = row + 1;
            newCol = 0;
        }

        // If the current cell is already filled, move to the next
        if (board[row][col] != '.') {
            return sudokuSolver(board, newRow, newCol);
        }

        // Try digits from '1' to '9' in the current empty cell
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit; // place digit

                if (sudokuSolver(board, newRow, newCol)) {
                    return true; // solved successfully
                }

                board[row][col] = '.'; // backtrack
            }
        }

        return false; // No valid digit found
    }

    /**
     * Check if placing a digit at board[row][col] is valid
     */
    public boolean isSafe(char[][] board, int row, int col, char digit) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) return false;
        }

        // Check 3x3 subgrid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }

        return true;
    }
}