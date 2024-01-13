package binarytree;

import java.util.ArrayList;

/*
Given a Binary Tree and a target key, you need to find all the ancestors of the given target key.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1
Example 1:

Input:
        1
      /   \
     2     3
target = 2
Output: 1
Example 2:

Input:
         1
       /   \
      2     3
    /  \   /  \
   4    5 6    8
  /
 7
target = 7
Output: 4 2 1
Your Task:
Your task is to complete the function Ancestors() that finds all the ancestors of the key in the given binary tree.
Note:
The return type is
cpp: vector
Java: ArrayList
python: list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
 */
public class Ancestors {
    public static ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean anc = anc(root, target, list);
        return list;
    }

    static boolean anc(Node root, int target, ArrayList<Integer> list) {
        if (root == null)
            return false;
        if (root.data == target)
            return true;
        if (anc(root.left, target, list) || anc(root.right, target, list)) {
            list.add(root.data);
            return true;
        }
        return false;
    }
}
