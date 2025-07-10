/* Problem: https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
 *
 * Time Complexity: O(n log n)
 * - Due to sorting the array
 *
 * Space Complexity: O(n)
 * - For the result list and internal sort operation
 */
import java.util.*;
class Solution {
    public List<Integer> findLonely(int[] nums) {
        // Edge case: only one number in the array, it's lonely by default
        if (nums.length == 1)
            return new ArrayList<>(Collections.singletonList(nums[0]));

        // Sort the array to easily check neighbors
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        int i;
        for (i = 0; i < nums.length - 1; i++) {
            // First element: check only right neighbor
            if (i == 0 && nums[i] + 1 < nums[i + 1]) {
                list.add(nums[i]);
            }
            // Middle elements: check both left and right neighbors
            else if (nums[i] + 1 < nums[i + 1] && nums[i] - 1 > nums[i - 1]) {
                list.add(nums[i]);
            }
        }

        // Check last element separately
        if (nums[i] - 1 > nums[i - 1]) {
            list.add(nums[i]);
        }

        return list;
    }
}

