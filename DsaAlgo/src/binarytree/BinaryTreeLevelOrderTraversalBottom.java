package binarytree;

import java.util.*;

/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 */
public class BinaryTreeLevelOrderTraversalBottom {
    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                l.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(l);
        }
        Collections.reverse(list);
        return list;
    }
}
