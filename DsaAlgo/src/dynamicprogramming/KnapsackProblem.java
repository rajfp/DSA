package dynamicprogramming;

import java.util.Arrays;

/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3.
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3};
        int[] wt = new int[]{4, 5, 1};
        System.out.println(knapSack(4, wt, values, values.length));
    }

    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int[] x : dp)
            Arrays.fill(x, -1);

        return knapSackk(W, wt, val, n);
    }

    static int knapSack(int[][] dp, int W, int[] wt, int[] val, int n) {
        if (W == 0 || n == 0)
            return 0;
        if (dp[n][W] == -1) {
            int include = 0;
            if (W >= wt[n - 1]) {
                include = val[n - 1] + knapSack(dp, W - wt[n - 1], wt, val, n - 1);
            }
            int exclude = knapSack(dp, W, wt, val, n - 1);
            dp[n][W] = Math.max(exclude, include);
        }
        return dp[n][W];
    }

    static int knapSackk(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= W; i++)
            dp[0][i] = 0;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++)
                if (j >= wt[i - 1]) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else dp[i][j] = dp[i - 1][j];
        }
        return dp[n][W];
    }
}
