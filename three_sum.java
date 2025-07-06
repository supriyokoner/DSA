// Problem: https://leetcode.com/problems/3sum/
// Language: Java
// Difficulty: Medium

/*
    Time Complexity: O(n^2)
    - Sorting the array: O(n log n)
    - Outer loop runs O(n), inner loop (two-pointer) runs O(n)
    - Total: O(n^2)

    Space Complexity: O(1) (ignoring the output list)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();

        // Sort the array to apply two-pointer approach
        Arrays.sort(nums);

        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;               // Left pointer
            int right = nums.length - 1;    // Right pointer

            // Two-pointer approach
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    arr.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return arr;
    }
}
