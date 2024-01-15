package binarytree;

import java.util.*;

/*
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the left ones only(i.e. leftmost).
For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N).
 */
public class TopViewBinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(topView(node1));
    }

    static class Pair {
        Node node;
        int distance;

        Pair(int distance, Node node) {
            this.distance = distance;
            this.node = node;
        }

    }

    static ArrayList<Integer> topView(Node root) {
        if (root == null)
            return new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (map.get(p.distance) == null) {
                map.put(p.distance, p.node.data);
            }
            if (p.node.left != null)
                q.add(new Pair(p.distance - 1, p.node.left));
            if (p.node.right != null)
                q.add(new Pair(p.distance + 1, p.node.right));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            list.add(i.getValue());
        }
        return list;
    }

}
