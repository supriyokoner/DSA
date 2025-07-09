/* Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Time Complexity: O(log n)
 * - Each iteration cuts the search space in half.
 *
 * Space Complexity: O(1)
 * - Constant extra space used.
 *
 * Approach: Modified Binary Search considering array is rotated at some pivot.
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Standard binary search with logic to handle rotation
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If target found at mid
            if (nums[mid] == target) return mid;

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target lies in this sorted half
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            // Otherwise, right half must be sorted
            else {
                // Check if target lies in right sorted half
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}

