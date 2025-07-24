/**
 * Problem: Linked List Cycle II (142)

 * Approach: Floyd's Cycle Detection (Tortoise and Hare)
 * 1. Use two pointers (`slow` and `fast`) to detect if a cycle exists.
 * 2. If they meet, there is a cycle.
 * 3. Reset `slow` to head, move both one step at a time to find the start of the cycle.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    // Constructor
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move one step
            fast = fast.next.next;    // Move two steps

            if (slow == fast) {
                // Cycle detected
                hasCycle = true;
                break;
            }
        }

        // Step 2: Find the entry point of the cycle
        if (hasCycle) {
            slow = head;              // Reset slow to start
            while (slow != fast) {    // Move both pointers at same pace
                slow = slow.next;
                fast = fast.next;
            }
            return slow;              // This is the cycle's entry point
        }

        // No cycle found
        return null;
    }
}
