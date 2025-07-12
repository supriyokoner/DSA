/* Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Time Complexity: O(log n)
 * - Binary search reduces the search space by half in each step.
 * 
 * Space Complexity: O(1)
 * - No extra space used apart from variables.
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            // If only two elements are left, return the larger one
            if (left + 1 == right) {
                return arr[left] > arr[right] ? left : right;
            }

            int mid = left + (right - left) / 2;

            // Check if mid is the peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // If slope is decreasing, move to the left half
            else if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // If slope is increasing, move to the right half
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}