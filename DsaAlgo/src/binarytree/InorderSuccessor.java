package binarytree;

/*
Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.


Example 1:

Input:
      2
    /   \
   1     3
K(data of x) = 2
Output: 3
Explanation:
Inorder traversal : 1 2 3
Hence, inorder successor of 2 is 3.

Example 2:

Input:
             20
            /   \
           8     22
          / \
         4   12
            /  \
           10   14
K(data of x) = 8
Output: 10
Explanation:
Inorder traversal: 4 8 10 12 14 20 22
Hence, successor of 8 is 10.


Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrderSuccessor(). This function takes the root node and the reference node as argument and returns the node that is inOrder successor of the reference node. If there is no successor, return null value.


Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(1).
 */
public class InorderSuccessor {

    public static void main(String[] args) {
        Node node1 = new Node(45);
        Node node2 = new Node(17);
        Node node3 = new Node(58);
        Node node4 = new Node(7);
        Node node5 = new Node(26);
        Node node6 = new Node(57);
        Node node7 = new Node(69);
        Node node8 = new Node(6);
        Node node9 = new Node(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        System.out.println(inOrder(node1, node4).data);
    }

    static Node inOrder(Node root, Node x) {
        if (root == null)
            return null;
        Node inOrder = null, curr = root;
        while (curr != null) {
            if (x.data < curr.data) {
                inOrder = curr;
                curr = curr.left;
            } else if (x.data > curr.data) {
                curr = curr.right;
            } else
                break;
        }
        if (curr != null) {
            if (curr.right != null) {
                return minValue(curr.right);
            } else
                return inOrder;
        }

        return inOrder;
    }

    private static Node minValue(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
}
