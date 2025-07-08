/* Problem: https://leetcode.com/problems/product-of-array-except-self/
   Time Complexity: O(n)
   - One pass to build prefix[]
   - One pass to build suffix[]
   - One pass to compute answer

   Space Complexity: O(n)
   - Uses extra arrays prefix[], suffix[], and ans[] of size n
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // Prefix product array where prefix[i] stores product of all elements before index i
        int prefix[] = new int[n];
        prefix[0] = 1;  // Nothing before index 0, so prefix product is 1

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            // For example: prefix[2] = nums[0] * nums[1]
        }

        // Suffix product array where suffix[i] stores product of all elements after index i
        int suffix[] = new int[n];
        suffix[n - 1] = 1;  // Nothing after last index, so suffix product is 1

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
            // For example: suffix[1] = nums[2] * nums[3] * ...
        }

        // Result array: multiply prefix[i] and suffix[i] for each index
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
            // Product of all elements except nums[i]
        }

        return ans;
    }
}