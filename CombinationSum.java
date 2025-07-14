/* Problem: https://leetcode.com/problems/combination-sum/
 *
 * Time Complexity: O(2^t), where t = target
 * - In the worst case, we try many combinations through recursion and backtracking.
 * 
 * Space Complexity: O(t)
 * - Recursive call stack and current combination list can go up to length t.
 */

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        // Start recursive backtracking
        makeCombination(candidates, target, 0, res, 0, new ArrayList<>());
        return res;
    }

    /**
     * Recursive helper to generate all valid combinations
     * 
     *  candidates - array of candidate numbers
     *  target - target sum we want to reach
     *  idx - current index in candidates array
     *  res - final result list to store all valid combinations
     *  total - current total sum of elements in the current combination
     *  comb - current combination being built
     */
    public void makeCombination(int[] candidates, int target, int idx,
                                List<List<Integer>> res, int total, List<Integer> comb) {
        // Found a valid combination
        if (total == target) {
            res.add(new ArrayList<>(comb)); // Add a copy to avoid reference issues
            return;
        }

        // Base case: sum exceeds target or index is out of bounds
        if (total > target || idx >= candidates.length) return;

        // Include the current number (can be reused)
        comb.add(candidates[idx]);
        makeCombination(candidates, target, idx, res, total + candidates[idx], comb);

        // Backtrack: remove last number added
        comb.remove(comb.size() - 1);

        // Exclude the current number and move to the next
        makeCombination(candidates, target, idx + 1, res, total, comb);
    }
}