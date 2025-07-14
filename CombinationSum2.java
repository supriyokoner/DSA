/* Problem: https://leetcode.com/problems/combination-sum-ii/
 *
 * Time Complexity: O(2^n)
 * - Each element can be included or excluded; duplicates are skipped.
 * - Pruning with sorting helps, but in worst case still exponential.
 * 
 * Space Complexity: O(n)
 * - Used by the recursion stack and the temporary combination list.
 */

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort to help skip duplicates
        List<List<Integer>> res = new ArrayList<>();

        // Begin DFS backtracking
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    /**
     * Backtracking function to find combinations summing to target
     * 
     *  candidates - sorted array of numbers
     *  target - remaining target to reach
     *  start - current index in array
     *  comb - current combination being built
     *  res - list of all valid combinations
     */
    private void dfs(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> res) {
        // If target becomes negative, backtrack
        if (target < 0) return;

        // If target reached, add the current combination to result
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates: only pick the first occurrence in a sequence
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // No point in continuing if the current number exceeds target
            if (candidates[i] > target) break;

            // Choose the current number
            comb.add(candidates[i]);

            // Move to the next index (each number used only once)
            dfs(candidates, target - candidates[i], i + 1, comb, res);

            // Backtrack: remove the number and try the next one
            comb.remove(comb.size() - 1);
        }
    }
}