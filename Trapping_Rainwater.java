/* Problem: https://leetcode.com/problems/trapping-rain-water/
    Time Complexity: O(n)
    Space Complexity: O(n)
    - Two auxiliary arrays (lMax and rMax) of size n each
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lMax[] = new int[n];   // Array to hold the maximum height from the left up to index i
        int rMax[] = new int[n];   // Array to hold the maximum height from the right up to index i

        // Compute left max for every index
        lMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }

        // Compute right max for every index
        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        // Calculate total water trapped at each index
        int waterTrap = 0;
        for (int i = 0; i < n; i++) {
            // Water level at current index is determined by the shorter of two max heights
            int waterLevel = Math.min(lMax[i], rMax[i]);
            waterTrap += waterLevel - height[i];
        }
        return waterTrap;
    }
}