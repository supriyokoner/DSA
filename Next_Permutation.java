/* Problem: https://leetcode.com/problems/next-permutation/

   Time Complexity: O(n)
   - One pass to find the breaking point (O(n))
   - One pass to find the next greater element (O(n))
   - One reverse operation (O(n))

   Space Complexity: O(1)
   - In-place modifications, no extra space used.
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int ind1 = -1;
        int ind2 = -1;

        // Step 1: Find the first index from the end where nums[i] < nums[i + 1]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind1 = i;
                break;
            }
        }

        // If no such index found, array is in descending order — reverse it to smallest permutation
        if (ind1 == -1) {
            reverse(nums, 0);
        } else {
            // Step 2: Find next greater element than nums[ind1] from the end
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[ind1]) {
                    ind2 = i;
                    break;
                }
            }

            // Swap to make the sequence slightly larger
            swap(nums, ind1, ind2);

            // Step 3: Reverse the right half to get the next smallest lexicographical order
            reverse(nums, ind1 + 1);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}