/* Problem: https://leetcode.com/problems/string-compression/
 *
 * Time Complexity: O(n)
 * - Each character is visited at most twice (once for counting, once for writing).
 * 
 * Space Complexity: O(1)
 * - Compression is done in-place, using only constant extra space.
 */

class Solution {
    public int compress(char[] chars) {
        int idx = 0; // Index for writing the compressed array
        int i = 0;   // Index for reading the original array

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[idx++] = currentChar;

            // If count > 1, write its digits individually
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[idx++] = c;
                }
            }
        }

        // Return the new length of the compressed array
        return idx;
    }
}