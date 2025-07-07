//  Problem: Maximum Subarray
//  Approach: Kadane's Algorithm
//  Time Complexity: O(n)
//  Space Complexity: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize maxSum with the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;

        // This variable will store the sum of the current subarray
        int currSum = 0;

        // Traverse through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the current subarray sum
            currSum += nums[i];

            // Update the maximum sum encountered so far
            maxSum = Math.max(maxSum, currSum);

            // If current sum becomes negative, reset it to 0
            // (Start a new subarray from next element)
            if (currSum < 0) {
                currSum = 0;
            }
        }

        // Return the maximum subarray sum found
        return maxSum;
    }
}

