/* Problem: https://leetcode.com/problems/group-anagrams/
 *
 * Time Complexity: O(n * k log k)
 * - n = number of strings in the input array
 * - k = average length of each string
 * - Sorting each string takes O(k log k)
 * 
 * Space Complexity: O(n * k)
 * - Storing all strings and keys in the HashMap
 */

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map sorted string -> list of anagrams
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert string to char array and sort it
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr); // Use sorted string as key

            // Add original string to the list corresponding to its sorted form
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        // Convert map values to list of lists and return
        List<List<String>> result = new ArrayList<>();
        for (String k : map.keySet()) {
            result.add(map.get(k));
        }
        return result;
    }
}