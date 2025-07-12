/* Problem: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 *
 * Time Complexity: O(n * m)
 * - In the worst case, `indexOf` can take O(n), and it's called up to n/m times.
 *   So overall complexity is O(n * m), where n = length of string s, m = length of part.
 * 
 * Space Complexity: O(n)
 * - StringBuilder stores the modified version of s.
 */

class Solution {
    public String removeOccurrences(String s, String part) {
        // Initialize StringBuilder with original string to allow efficient deletion
        StringBuilder sb = new StringBuilder(s);

        // Find the index of the first occurrence of 'part' in the current string
        int i = sb.indexOf(part);

        // Repeat until no more occurrences of 'part' are found
        while (i != -1) {
            // Remove the substring 'part' from index i to i + part.length()
            sb.delete(i, i + part.length());

            // Check again for next occurrence (as the string has changed)
            i = sb.indexOf(part);
        }

        // Convert StringBuilder back to String and return the final result
        return sb.toString();
    }
}