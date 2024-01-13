package binarytree;

import java.util.ArrayList;
import java.util.Collections;

/*
Given a Binary Tree of size N, find all the nodes which don't have any sibling. You need to return a list of integers containing all the nodes that don't have a sibling in sorted order.

Two nodes are said to be siblings if they are present at the same level, and their parents are same.

Note: Root node can not have a sibling so it cannot be included in our answer.

Example 1:

Input :
       37
      /
    20
    /
  113

Output: 20 113
Explanation: 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3

Output: -1
Explanation: Every node has a sibling.

Your Task:
You dont need to read input or print anything. Complete the function noSibling() which takes the root of the tree as input parameter and returns a list of integers containing all the nodes that don't have a sibling in sorted order. If all nodes have a sibling, then the returning list should contain only one element -1.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(Height of the tree)
 */
public class PrintAllNodesDontHaveSibling {
    ArrayList<Integer> noSibling(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        noSib(root, list);
        if (list.isEmpty()) {
            list.add(-1);
            return list;
        }
        Collections.sort(list);
        return list;
    }

    void noSib(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        if (root.left != null && root.right == null && !list.contains(root.left.data))
            list.add(root.left.data);
        if (root.right != null && root.left == null && !list.contains(root.right.data))
            list.add(root.right.data);
        noSib(root.left, list);
        noSib(root.right, list);
    }
}
