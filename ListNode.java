/**
 * Problem: Reverse Linked List (206)

 * Time Complexity: O(n) - where n is the number of nodes in the list.
 * Space Complexity: O(1) - in-place reversal without extra memory.
 */

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;

    // Default constructor
    ListNode() {}

    // Constructor to initialize value
    ListNode(int val) {
        this.val = val;
    }

    // Constructor to initialize value and next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;      // Initially, no node before head
        ListNode curr = head;      // Start with the head
        ListNode nxt = null;       // To temporarily store the next node

        // Iterate through the list
        while (curr != null) {
            nxt = curr.next;       // Save the next node
            curr.next = prev;      // Reverse the current node's pointer
            prev = curr;           // Move prev one step ahead
            curr = nxt;            // Move curr one step ahead
        }

        // At the end, prev will be the new head
        return prev;
    }
}