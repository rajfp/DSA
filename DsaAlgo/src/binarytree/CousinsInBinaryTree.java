package binarytree;

/*
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
/*
 Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.*/
public class CousinsInBinaryTree {
    int levelX = -1;
    int levelY = -1;

    public boolean isCousins(Node root, int x, int y) {
        if (root == null || root.data == x || root.data == y)
            return false;
        return cousins(root, x, y, 1);
    }

    private boolean cousins(Node root, int x, int y, int level) {
        if (root == null)
            return true;
        if ((root.left!=null && root.left.data == x && root.right!=null && root.right.data == y)
                ||(root.left!=null && root.left.data == y && root.right!=null && root.right.data == x))
            return false;
        if (root.data == x) {
            levelX = level;
            return true;
        }
        if (root.data == y) {
            levelY = level;
            return true;
        }
        boolean left = cousins(root.left, x, y, level + 1);
        boolean right = cousins(root.right, x, y, level + 1);
        if(level == 1)
            return (levelX != -1 && levelY != -1 && levelX == levelY && right && left);
        else
            return right || left;
    }

}
