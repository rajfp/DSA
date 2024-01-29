package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an array of N positive integers, print k largest elements from the array.

Example 1:

Input:
N = 5, k = 2
arr[] = {12,5,787,1,23}
Output: 787 23
Explanation: First largest element in
the array is 787 and the second largest
is 23.
Example 2:

Input:
N = 7, k = 3
arr[] = {1,23,12,9,30,2,50}
Output: 50 30 23
Explanation: Three Largest element in
the array are 50, 30 and 23.
Your Task:
Complete the function kLargest() that takes the array, N and K as input parameters and returns a list of k largest element in descending order.

Expected Time Complexity: O(N log K)
Expected Auxiliary Space: O(K)
 */
public class KLargestElements {
    public static void main(String[] args) {
        int[] a = new int[]{1, 23, 12, 9, 30, 2, 50};
        System.out.println(kLargest(a, a.length, 3));
    }

    public static ArrayList<Integer> kLargest(int a[], int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a)
            queue.add(i);
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
//    public static ArrayList<Integer> kLargest(int a[], int n, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < k; i++)
//            queue.add(a[i]);
//        for (int i = k; i < n; i++) {
//            if (a[i] > queue.peek()) {
//                queue.poll();
//                queue.add(a[i]);
//            }
//        }
//        while (!queue.isEmpty()) {
//            list.add(queue.poll());
//        }
//        return list;
//    }
