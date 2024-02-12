package dynamicprogramming;

import java.util.Arrays;

/*
Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

Example 1:

Input:
N = 3, sum = 4
coins = {1,2,3}
Output: 4
Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
Example 2:

Input:
N = 4, Sum = 10
coins = {2,5,3,6}
Output: 5
Explanation: Five Possible ways are: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which accepts an array coins its size N and sum as input parameters and returns the number of ways to make change for given sum of money.

Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum)
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5};
        System.out.println(coinChange(a, 6));
    }

    //    static public long count(int[] coins, int n, int sum) {
//        long[][] a = new long[coins.length][sum + 1];
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = 0; j <= sum; j++) {
//                a[i][j] = -1;
//            }
//        }
//        return count(a, coins, n, sum);
//    }
//
//
//    static public long count(long[][] a, int[] coins, int n, int sum) {
//        if (sum == 0)
//            return 1;
//        if (sum < 0)
//            return 0;
//        if (n == 0)
//            return 0;
//        if (a[n - 1][sum] == -1)
//            a[n - 1][sum] = count(a, coins, n, sum - coins[n - 1]) + count(a, coins, n - 1, sum);
//        return a[n - 1][sum];
//    }
    static public int coinChange(int[] coins, int sum) {
        if (sum == 0)
            return 0;
        int[][] a = new int[coins.length][sum + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                a[i][j] = -1;
            }
        }
        int count = count(a, coins, coins.length, sum);
        return (count >= 100000) ? -1 : count;
    }

    static public int count(int[][] a, int[] coins, int n, int sum) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 100000;
        if (n == 0)
            return 100000;
        if (a[n - 1][sum] == -1)
            a[n - 1][sum] = Math.min(1 + count(a, coins, n, sum - coins[n - 1]), count(a, coins, n - 1, sum));
        return a[n - 1][sum];
    }
}
