package linkedlist;

public class ReverseDLL {
    class Node
    {
        int data;
        Node next, prev;
        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node reverseDLL(Node  head)
    {
        Node prev = null,curr = head;
        while(curr!=null){
            curr.prev = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr.prev;
        }
        return prev;
    }
}
