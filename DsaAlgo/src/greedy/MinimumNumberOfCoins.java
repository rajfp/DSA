package greedy;

import java.util.ArrayList;
import java.util.List;

/*
Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required.


Example 1:

Input: N = 43
Output: 20 20 2 1
Explaination:
Minimum number of coins and notes needed
to make 43.

Example 2:

Input: N = 1000
Output: 500 500
Explaination: minimum possible notes
is 2 notes of 500.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minPartition() which takes the value N as input parameter and returns a list of integers in decreasing order.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 */
public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        System.out.println(minPartition(1000));
    }

    static List<Integer> minPartition(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            if (n >= 2000) {
                list.add(2000);
                n = n - 2000;
            } else if (n >= 500) {
                list.add(500);
                n = n - 500;
            } else if (n >= 200) {
                list.add(200);
                n = n - 200;
            } else if (n >= 100) {
                list.add(100);
                n = n - 100;
            } else if (n >= 50) {
                list.add(50);
                n = n - 50;
            } else if (n >= 20) {
                list.add(20);
                n = n - 20;
            } else if (n >= 10) {
                list.add(10);
                n = n - 10;
            } else if (n >= 5) {
                list.add(5);
                n = n - 5;
            } else if (n >= 2) {
                list.add(2);
                n = n - 2;
            } else {
                list.add(1);
                n = 0;
            }
        }
        return list;
    }
}
