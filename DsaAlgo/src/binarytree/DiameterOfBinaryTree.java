package binarytree;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l + r, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

/*
class Solution {

    static int max;

    static int height(TreeNode root){
        if(root==null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        max = Math.max(max, left+right);

        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        height(root);
        return max;
    }
}
 */