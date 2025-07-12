/* Problem: https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Time Complexity: O(n)
 * - Each character is processed at most twice (once in reading, once in reversing).
 * 
 * Space Complexity: O(n)
 * - Extra space used for StringBuilder and result string.
 */

class Solution {
    public String reverseWords(String s) {
        int i = 0, j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        String ans = "";

        // Trim trailing and leading spaces manually
        while (j >= i) {
            if (s.charAt(j) != ' ') {
                sb.append(s.charAt(j--));
            } else {
                while (i <= j && s.charAt(j) == ' ') j--; // skip extra spaces
                if (sb.length() > 0) {
                    ans += sb.reverse() + " ";
                    sb.setLength(0);
                }
            }
        }

        // Append the last word
        ans += sb.reverse();

        // Remove trailing space if any
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') {
            ans = ans.substring(0, ans.length() - 1);
        }

        return ans;
    }
}