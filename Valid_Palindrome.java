/* Problem: https://leetcode.com/problems/valid-palindrome/
 *
 * Time Complexity: O(n)
 * - Each character in the string is visited at most once.
 * 
 * Space Complexity: O(1)
 * - Constant extra space used for pointers and comparisons.
 */

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            // Skip non-alphanumeric characters from the left
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            // Skip non-alphanumeric characters from the right
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            // Compare characters in a case-insensitive way
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }

        return true;
    }
}

