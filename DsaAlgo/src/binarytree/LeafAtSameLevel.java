package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input:
            1
          /   \
         2     3
Output:
1
Explanation:
Leaves 2 and 3 are at same level.
Example 2:

Input:
            10
          /    \
        20      30
       /  \
     10    15
Output:
0
Explanation:
Leaves 10, 15 and 30 are not at same level.
Your Task:
You dont need to read input or print anything. Complete the function check() which takes root node as input parameter and returns true/false depending on whether all the leaf nodes are at the same level or not.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 */
public class LeafAtSameLevel {
    boolean check(Node root) {
        if(root == null)return false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node x = q.poll();
                if (x.left != null || x.right != null)
                    count++;
                if (x.left != null)
                    q.add(x.left);
                if (x.right != null)
                    q.add(x.right);
            }
            if (count != size && count > 0)
                return false;
        }
        return true;
    }
}
