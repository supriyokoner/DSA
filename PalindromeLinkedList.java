/**
 * Problem: Palindrome Linked List (234)

 * Approach:
 * 1. Use slow and fast pointers to find the middle of the list.
 * 2. Reverse the second half of the list.
 * 3. Compare the first and second halves node by node.
 * 
 * Time Complexity: O(n) – Traverse list twice.
 * Space Complexity: O(1) – In-place reversal.
 */

/**
 * Definition for singly-linked list node.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public boolean isPalindrome(ListNode head) {
        // Base cases: empty list or single node
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode curr = slow;
        ListNode prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Compare first and second halves
        ListNode left = head;
        ListNode right = prev; // Start of reversed second half
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}