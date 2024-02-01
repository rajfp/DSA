package binarytree;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        Node node6 = new Node(6);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        flatten(node);
    }

    static public void flatten(Node root) {
        if (root == null)
            return;
        Node current = root;
        while (current != null) {
            if (current.left != null) {
                Node temp = current.left;
                while (temp.right != null)
                    temp = temp.right;
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
//  My solition
//    static public void flatten(Node root) {
//        if (root == null)
//            return;
//        Node p;
//        node = new Node(root.data);
//        p = node;
//        convertToLinkedList(root);
//        node.right = null;
//        root = p.right;
//        System.out.println(root);
//    }
//
//    static private void convertToLinkedList(Node root) {
//        if (root == null) {
//            return;
//        }
//        node.right = new Node(root.data);
//        node = node.right;
//        System.out.println(root.data + " ");
//        convertToLinkedList(root.left);
//        convertToLinkedList(root.right);
//    }
}
