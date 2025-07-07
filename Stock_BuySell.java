//  Problem: Best Time to Buy and Sell Stock (LeetCode #121)
//  Approach: One Pass
//  Time Complexity: O(n)
//  Space Complexity: O(1)

class Solution {

    public int maxProfit(int[] prices) {
        // Initialize the minimum price as the first day's price
        int buy = prices[0];

        // Initialize profit to 0
        int profit = 0;

        // Traverse the price array starting from day 1
        for (int i = 1; i < prices.length; i++) {

            // If we find a lower price, update the buying price
            if (prices[i] < buy) {
                buy = prices[i];
            }

            // Calculate profit if selling today and update max profit if it's higher
            if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }

        // Return the maximum profit found
        return profit;
    }
}

