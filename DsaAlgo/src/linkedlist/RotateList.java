package linkedlist;

/*
Given the head of a linked list, rotate the list to the right by k places.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */
public class RotateList {
    public Node rotateRight(Node head, int k) {
        if (head == null)
            return null;
        Node p = head, q = head;
        int size = 0;
        while (p != null) {
            size++;
            q = p;
            p = p.next;
        }
        k = k % size;
        if (k == 0)
            return head;
        p = head;
        size = size - k - 1;
        while (size > 0) {
            p = p.next;
            size--;
        }
        q.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}
