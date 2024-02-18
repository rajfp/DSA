package dynamicprogramming;

import java.util.Arrays;

/*
Given a fence with n posts and k colors, find out the number of ways of painting the fence so that not more than two consecutive posts have the same colors. Since the answer can be large return it modulo 109 + 7.

Example 1:

Input:
n = 3
k = 2
Output: 6
Explanation:
We have following possible combinations:



Example 2:

Input:
n = 2
k = 4
Output: 16
Explanation:
After coloring first post with
4 possible combinations, you can still color
next posts with all 4 colors. Total possible
combinations will be 4x4=16
Your Task:
Since, this is a function problem. You don't need to take any input or print anything, as it is already accomplished by the driver code. You just need to complete the function countWays() that takes n and k as parameters and returns the number of ways in which the fence can be painted (modulo 109 + 7).
 */
public class PaintingTheFence {
    public static void main(String[] args) {
        System.out.println(countWays(2, 4));
    }
    static long countWays(int n, int k) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return countWays(dp, n, k);
    }

    static long countWays(long[] dp, int n, int k) {
        if (n == 1)
            return k % 1000000007;
        if (n == 2)
            return ((long) (k % 1000000007) * (k % 1000000007 - 1) + k % 1000000007) % 1000000007;
        if (dp[n] == -1)
            dp[n] = ((countWays(dp, n - 2, k) * (k - 1) % 1000000007) + (countWays(dp, n - 1, k) * (k - 1) % 1000000007)) % 1000000007;
        return dp[n];
    }
}
