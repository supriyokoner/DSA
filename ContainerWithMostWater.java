
/* Problem: https://leetcode.com/problems/container-with-most-water/
    Time Complexity: O(n)
    Space Complexity: O(1)
    - No extra space used
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        // Two-pointer approach to find the max water container
        while (left < right) {
            int area;

            // Calculate area with current left and right
            if (height[left] < height[right]) {
                area = height[left] * (right - left);
                maxArea = Math.max(area, maxArea);
                left++;  // Move the shorter line inward
            } else {
                area = height[right] * (right - left);
                maxArea = Math.max(area, maxArea);
                right--; // Move the shorter line inward
            }
        }

        return maxArea;
    }
}

