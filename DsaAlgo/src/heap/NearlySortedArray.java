package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an array of n elements, where each element is at most k away from its target position, you need to sort the array optimally.

Example 1:

Input:
n = 7, k = 3
arr[] = {6,5,3,2,8,10,9}
Output: 2 3 5 6 8 9 10
Explanation: The sorted array will be
2 3 5 6 8 9 10
Example 2:

Input:
n = 5, k = 2
arr[] = {3,1,4,2,5}
Output: 1 2 3 4 5
Note: DO NOT use STL sort() function for this question.

Your Task:
You are required to complete the method nearlySorted() which takes 3 arguments and returns the sorted array.


 */
public class NearlySortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,4,2,5};

        System.out.println(nearlySorted(a, a.length, 2));
    }

    static ArrayList<Integer> nearlySorted(int a[], int num, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k; i++)
            queue.add(a[i]);
        for (int i = k + 1; i < a.length; i++) {
            list.add(queue.poll());
            queue.add(a[i]);
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
