package linkedlist;

/*
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)
 */
public class MergeSort {
    public static void main(String[] args) {
        Node p = new Node(3);
        Node res = mergeSort(p);
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = mid(head);
        Node middleNext = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(middleNext);
        return merge(left, right);
    }

    static Node mid(Node head) {
        Node p = head, q = head;
        while (p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    static Node merge(Node head1, Node head2) {
        Node p = head1, q = head2, head, k;
        if (head1.data < head2.data) {
            head = head1;
            p = p.next;
        } else {
            head = head2;
            q = q.next;
        }
        k = head;
        while (p != null && q != null) {
            if (p.data < q.data) {
                k.next = p;
                k = k.next;
                p = p.next;
            } else {
                k.next = q;
                k = k.next;
                q = q.next;
            }
        }
        if (p == null)
            k.next = q;
        else
            k.next = p;
        return head;
    }
}
