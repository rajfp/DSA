package linkedlist;

/*
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 */
public class Segregate012 {
    static Node segregate(Node head) {
        Node p = head;
        Node list0 = null;
        Node list1 = null;
        Node list2 = null;
        Node head0 = null;
        Node head1 = null;
        Node head2 = null;
        while (p != null) {
            if (p.data == 0) {
                if (head0 == null) {
                    head0 = p;
                    list0 = p;
                } else {
                    list0.next = p;
                    list0 = list0.next;
                }
            } else if (p.data == 1) {
                if (head1 == null) {
                    head1 = p;
                    list1 = p;
                } else {
                    list1.next = p;
                    list1 = list1.next;
                }
            } else if (p.data == 2) {
                if (head2 == null) {
                    head2 = p;
                    list2 = p;
                } else {
                    list2.next = p;
                    list2 = list2.next;
                }
            }
            p = p.next;
        }
        if (head0 != null && head1 != null && head2 != null) {
            list0.next = head1;
            list1.next = head2;
            list2.next = null;
            return head0;
        }
        if (head0 == null && head1 != null && head2 != null) {
            list1.next = head2;
            list2.next = null;
            return head1;
        }
        if (head0 == null && head1 == null && head2 != null) {
            list2.next = null;
            return head2;
        }
        if (head0 == null && head1 != null && head2 == null) {
            list1.next = null;
            return head1;
        }

        if (head1 == null && head0 != null && head2 != null) {
            list0.next = head2;
            list2.next = null;
            return head0;
        }
        if (head1 == null && head0 == null && head2 != null) {
            list2.next = null;
            return head2;
        }
        if (head1 == null && head0 != null && head2 == null) {
            list0.next = null;
            return head0;
        }
        if (head2 == null && head0 != null && head1 != null) {
            list0.next = head1;
            list1.next = null;
            return head0;
        }
        if (head2 == null && head0 == null && head1 != null) {
            list1.next = null;
            return head1;
        }
        if (head2 == null && head0 != null && head1 == null) {
            list0.next = null;
            return head0;
        }
        return head;
    }
}
