package linkedlist;

/*
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.
Your Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)
 */
public class Palindrome {
    boolean isPalindrome(Node head) {
        boolean res;
        if (head == null || head.next == null)
            return true;
        Node fastPtr = head, slowPtr = head, prevNodePtr = head, midNode = null;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prevNodePtr = slowPtr;
            slowPtr = slowPtr.next;
        }

        if (fastPtr != null) {
            midNode = slowPtr;
            slowPtr = slowPtr.next;
        }
        prevNodePtr.next = null;
        Node secondHalf = slowPtr;
        secondHalf = reverse(secondHalf);
        res = compareLists(head, secondHalf);
        secondHalf = reverse(secondHalf);
        if (midNode != null) {
            prevNodePtr.next = midNode;
            midNode.next = secondHalf;
        } else
            prevNodePtr.next = secondHalf;
        return res;
    }

    Node reverse(Node secondHalf) {
        Node prev = null, curr = secondHalf;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHalf = prev;

        return secondHalf;
    }

    boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return false;
        }

        if (temp1 == null && temp2 == null)
            return true;

        return false;
    }
}
