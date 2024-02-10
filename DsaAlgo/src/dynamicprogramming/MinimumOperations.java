package dynamicprogramming;

import java.util.Arrays;

/*
Given a number N. Find the minimum number of operations required to reach N starting from 0. You have 2 operations available:

Double the number
Add one to the number
Example 1:

Input:
N = 8
Output: 4
Explanation:
0 + 1 = 1 --> 1 + 1 = 2 --> 2 * 2 = 4 --> 4 * 2 = 8.
Example 2:

Input:
N = 7
Output: 5
Explanation:
0 + 1 = 1 --> 1 + 1 = 2 --> 1 + 2 = 3 --> 3 * 2 = 6 --> 6 + 1 = 7.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minOperation() which accepts an integer N and return number of minimum operations required to reach N from 0.

Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(1)
 */
public class MinimumOperations {
    public static void main(String[] args) {
        System.out.println(minOperation(8));
    }

    static int minOperation(int n) {
        int[] a = new int[n + 1];
        Arrays.fill(a, -1);
        return minOperation(n, a);
    }

    static int minOperation(int n, int[] a) {
        if (a[n] == -1) {
            if (n == 0 || n == 1) {
                a[n] = 1;
                return a[n];
            }
            if (n % 2 == 0)
                a[n] = 1 + minOperation(n / 2, a);
            else
                a[n] = 1 + minOperation(n - 1, a);
        }
        return a[n];
    }
}
