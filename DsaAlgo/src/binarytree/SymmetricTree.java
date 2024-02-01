package binarytree;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 */
public class SymmetricTree {
    public boolean isSymmetric(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return symmetric(root.left, root.right);

    }

    public boolean symmetric(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null)
            return false;
        return root1.data == root2.data
                && symmetric(root1.left, root2.right)
                && symmetric(root1.right, root2.left);
    }

}
