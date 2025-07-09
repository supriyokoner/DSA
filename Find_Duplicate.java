/* Problem: https://leetcode.com/problems/find-the-duplicate-number/
   Time Complexity: O(n)
   Space Complexity: O(n)
  - We use an extra boolean array to track visited numbers.
 */

class Solution {
    public int findDuplicate(int[] nums) {
        // Create a boolean array to track seen numbers
        boolean[] freq = new boolean[nums.length];
        
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If the number was already seen, it's the duplicate
            if (freq[nums[i]]) return nums[i];
            // Mark the number as seen
            freq[nums[i]] = true;
        }

        return -1;
    }
}