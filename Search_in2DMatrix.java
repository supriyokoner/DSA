/*  Problem: https://leetcode.com/problems/search-a-2d-matrix-ii/
    Time Complexity: O(m + n)
    Space Complexity: O(1)
    - No extra space used
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start from the bottom-left corner
        int row = matrix.length - 1;
        int col = 0;

        // Move up or right based on comparison
        while (row >= 0 && col < matrix[0].length) {
            int start = matrix[row][col];

            if (target == start)
                return true;       // Target found
            else if (target < start)
                row--;             // Move up
            else
                col++;             // Move right
        }

        // Target not found
        return false;
    }
}