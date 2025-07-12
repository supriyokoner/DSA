/* Problem: https://leetcode.com/problems/valid-anagram/
 *
 * Time Complexity: O(n)
 * - Each character in both strings is processed once.
 * 
 * Space Complexity: O(n)
 * - HashMap stores up to n characters from the first string.
 */

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they can't be anagrams
        if (s.length() != t.length()) return false;

        // Count character frequencies in string s
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Decrease frequency for characters found in string t
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (map.get(key) != null) {
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            } else {
                return false;
            }
        }

        // If map is empty, all characters matched
        return map.isEmpty();
    }
}