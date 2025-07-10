/* Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Time Complexity: O(log n)
 * - Binary search is used to reduce the search space by half each time.
 *
 * Space Complexity: O(1)
 * - No extra space used apart from variables.
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int si = 0, ei = nums.length - 1;

        while (si < ei) {
            int mid = si + (ei - si) / 2;

            // Ensure mid is even so mid and mid+1 form a pair
            if (mid % 2 == 1)
                mid--;

            // If the pair is valid, move to the right
            if (nums[mid] == nums[mid + 1]) {
                si = mid + 2;
            } else {
                // Unique element is on the left side (including mid)
                ei = mid;
            }
        }

        // si will be pointing to the single element
        return nums[si];
    }
}