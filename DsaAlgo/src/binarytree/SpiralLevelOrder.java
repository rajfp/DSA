package binarytree;

import java.util.ArrayList;

/*
Given a binary tree and the task is to find the spiral order traversal of the tree.

Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right.

For below tree, function should return 1, 2, 3, 4, 5, 6, 7.





Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40
Your Task:
The task is to complete the function findSpiral() which takes root node as input parameter and returns the elements in spiral form of level order traversal as a list. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 */
public class SpiralLevelOrder {
    ArrayList<Integer> findSpiral(Node root) {
        int h = height(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= h; i++)
            printLevelOrderTraversal(root, i, list, i);
        return list;
    }

    void printLevelOrderTraversal(Node root, int level, ArrayList<Integer> list, int i) {
        if (root == null)
            return;
        if (level == 1) {
            list.add(root.data);
        } else {
            if (i % 2 == 0) {
                printLevelOrderTraversal(root.left, level - 1, list, i);
                printLevelOrderTraversal(root.right, level - 1, list, i);
            } else {
                printLevelOrderTraversal(root.right, level - 1, list, i);
                printLevelOrderTraversal(root.left, level - 1, list, i);
            }
        }
    }

    int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));

    }
}
