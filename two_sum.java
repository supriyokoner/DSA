// Problem: https://leetcode.com/problems/two-sum/
// Language: Java
// Difficulty: Easy

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exists, return indices
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current number with its index
            map.put(nums[i], i);
        }

        // Return default value if no solution found (problem guarantees one solution)
        return new int[]{-1, -1};
    }
}
