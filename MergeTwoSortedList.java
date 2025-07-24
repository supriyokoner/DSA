/**
 * Problem: Merge Two Sorted Lists (21)

 * Time Complexity: O(m + n) - where m and n are the lengths of the two lists.
 * Space Complexity: O(1) - no extra space used apart from pointers.
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node to simplify edge cases (e.g., empty lists)
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Traverse both lists and attach the smaller node to the merged list
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; // Move the temp pointer forward
        }

        // Attach the remaining nodes, if any
        if (list1 != null) {
            temp.next = list1;
        } else if (list2 != null) {
            temp.next = list2;
        }

        // Return the merged list (excluding dummy node)
        return dummy.next;
    }
}

