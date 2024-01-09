package linkedlist;

/*
Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the list (in-place) and return head of the merged list.


Example 1:

Input:
N = 4, M = 3
valueN[] = {5,10,15,40}
valueM[] = {2,3,20}
Output: 2 3 5 10 15 20 40
Explanation: After merging the two linked
lists, we have merged list as 2, 3, 5,
10, 15, 20, 40.
Example 2:

Input:
N = 2, M = 2
valueN[] = {1,1}
valueM[] = {2,4}
Output:1 1 2 4
Explanation: After merging the given two
linked list , we have 1, 1, 2, 4 as
output.
Your Task:
The task is to complete the function sortedMerge() which takes references to the heads of two linked lists as the arguments and returns the head of merged linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(1)
 */
public class SortedMerge {
    Node sortedMerge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node p;
        if (head1.data < head2.data) {
            p = head1;
            Node q = head1.next;
            Node res = head1;
            Node r = head2;
            while (q != null && r != null) {
                if (q.data < r.data) {
                    res.next = q;
                    res = res.next;
                    q = q.next;
                } else {
                    res.next = r;
                    res = res.next;
                    r = r.next;
                }
            }
            while (q != null) {
                res.next = q;
                res = res.next;
                q = q.next;
            }
            while (r != null) {
                res.next = r;
                res = res.next;
                r = r.next;
            }
        } else {
            p = head2;
            Node q = head2.next;
            Node res = head2;
            Node r = head1;
            while (q != null && r != null) {
                if (q.data < r.data) {
                    res.next = q;
                    res = res.next;
                    q = q.next;
                } else {
                    res.next = r;
                    res = res.next;
                    r = r.next;
                }
            }
            while (q != null) {
                res.next = q;
                res = res.next;
                q = q.next;
            }
            while (r != null) {
                res.next = r;
                res = res.next;
                r = r.next;
            }
        }
        return p;
    }
}
