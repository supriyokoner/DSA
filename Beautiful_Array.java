/* Problem: https://leetcode.com/problems/beautiful-array/
 *
   Time Complexity: O(n)
 * - Each element is processed once in the loop.
 
 * Space Complexity: O(n)
 * - Uses extra space to construct the beautiful array.
 */
import java.util.*;
class Solution {
    public int[] beautifulArray(int n) {
        // Start with initial array [1]
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        // Keep expanding the list until it reaches size n
        while (list.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();

            // Generate all odd values: 2*i - 1
            for (int i : list) {
                if (i * 2 - 1 <= n)
                    temp.add(i * 2 - 1);
            }

            // Generate all even values: 2*i
            for (int i : list) {
                if (i * 2 <= n)
                    temp.add(i * 2);
            }

            list = temp;
        }

        // Convert ArrayList to int array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}