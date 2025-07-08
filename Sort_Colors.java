/* Problem: https://leetcode.com/problems/sort-colors/
    Time Complexity: O(n)
    Space Complexity: O(1)
    - Only a fixed-size array of length 3 is used for counting
*/
class Solution {
    public void sortColors(int[] nums) {

        // Step 1: Count the frequency of 0s, 1s, and 2s
        int freq[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        // Step 2: Overwrite the array based on the frequency counts
        for (int i = 0, j = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                nums[j++] = i;
                freq[i]--;
            }
        }
    }
}

