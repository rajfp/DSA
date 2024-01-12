package binarytree;

import java.util.ArrayList;

/*
Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that returns an array containing the nodes that are in the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 */
public class LeftViewBinaryTree {
    int maxLevel = 0;

    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        leftV(root, 1, list);
        return list;
    }

    void leftV(Node root, int level, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }
        leftV(root.left, level + 1, list);
        leftV(root.right, level + 1, list);
    }
}
