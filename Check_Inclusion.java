/* Problem: https://leetcode.com/problems/permutation-in-string/
 *
 * Time Complexity: O(n * 26) => O(n)
 * - n = length of s2
 * - For each window of size s1.length(), we compare maps using `.equals()`, which takes O(26) = O(1) since characters are lowercase English letters.
 * 
 * Space Complexity: O(1)
 * - Uses two HashMaps of fixed size (up to 26 characters), so constant space.
 */

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer, it's impossible for s2 to contain its permutation
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Initialize both maps with the first window of size s1.length()
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // Check if the first window is a valid permutation
        if (map1.equals(map2)) return true;

        // Slide the window over the rest of s2
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            char charRight = s2.charAt(right);
            map2.put(charRight, map2.getOrDefault(charRight, 0) + 1); // add new char to window

            char leftChar = s2.charAt(left);
            map2.put(leftChar, map2.get(leftChar) - 1); // remove leftmost char from window
            if (map2.get(leftChar) == 0) {
                map2.remove(leftChar); // clean up to keep maps comparable
            }

            // Check current window
            if (map1.equals(map2)) return true;

            left++; // move window forward
        }

        // No permutation found
        return false;
    }
}