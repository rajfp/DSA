package binarytree;

import java.util.ArrayList;

/*
Given a Binary Search Tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

Example 1:

Input:
      4
    /   \
   2     9
k = 2
Output: 4
Example 2:

Input:
       9
        \
          10
K = 1
Output: 10
Your Task:
You don't need to read input or print anything. Your task is to complete the function kthLargest() which takes the root of the BST and an integer K as inputs and returns the Kth largest element in the given BST.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H) where H is max recursion stack of height H at a given time.


 */
public class KthLargestElementBST {
    public int kthLargest(Node root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTrav(root, list);
        return list.get(list.size() - k);
    }

    void inorderTrav(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        inorderTrav(root.left, list);
        list.add(root.data);
        inorderTrav(root.right, list);
    }
}
