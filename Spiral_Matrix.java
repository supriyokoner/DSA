/* Problem: https://leetcode.com/problems/spiral-matrix/
 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * - For storing the result in a list.
 * 
 * m = number of rows, n = number of columns
 */
import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Define the boundaries of the matrix
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;

        // List to store the result
        ArrayList<Integer> list = new ArrayList<>();

        // Loop until boundaries collapse
        while (startRow <= endRow && startCol <= endCol) {
            
            // Traverse the top row from left to right
            for (int i = startCol; i <= endCol; i++) {
                list.add(matrix[startRow][i]);
            }

            // Traverse the right column from top to bottom
            for (int i = startRow + 1; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }

            // Traverse the bottom row from right to left
            // Only if there's more than one row remaining
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) break; // Avoid double counting
                list.add(matrix[endRow][i]);
            }

            // Traverse the left column from bottom to top
            // Only if there's more than one column remaining
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) break; // Avoid double counting
                list.add(matrix[i][startCol]);
            }

            // Move inward to the next layer
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return list;
    }
}