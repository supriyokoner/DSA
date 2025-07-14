/* Problem: https://leetcode.com/problems/palindrome-partitioning/
 *
 * Time Complexity: O(2^n * n)
 * - There are 2^n possible partitions.
 * - Each partition may take O(n) time to check palindromes.
 * 
 * Space Complexity: O(n)
 * - Recursion stack and path list can go up to O(n) in depth.
 */

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    /**
     * Backtracking function to generate all palindrome partitions
     * 
     *  s - input string
     *  start - current index to explore substring
     *  path - current list of palindromic substrings
     *  ans - final list of all valid partitions
     */
    public void backtrack(String s, int start, List<String> path, List<List<String>> ans) {
        // If we've reached the end, add the current path as a partition
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try all possible substrings starting from 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);

            // Only proceed if substring is a palindrome
            if (isPalindrome(sub)) {
                path.add(sub);
                backtrack(s, end, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    
     // Helper function to check if a string is a palindrome

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }
}