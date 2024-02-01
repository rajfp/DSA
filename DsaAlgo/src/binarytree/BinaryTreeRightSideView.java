package binarytree;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []

 */
public class BinaryTreeRightSideView {
    int maxLevel = 0;

    public List<Integer> rightSideView(Node root) {
        List<Integer> list = new ArrayList<>();
        rightView(root, list, 1);
        return list;
    }

    private void rightView(Node root, List<Integer> list, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }
        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }
}
