package dynamicprogramming;

import java.util.Arrays;

/*
Given an array of integers cost[] of length N, where cost[i] is the cost of the ith step on a staircase. Once the cost is paid, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.

Example 1:

Input:
N = 3
cost[] = {10, 15, 20}
Output:
15
Explanation:

Cheapest option is to start at cost[1],
pay that cost, and go to the top.



Example 2:

Input:
N = 10
arr[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
Output:
6
Explanation:
Cheapest option is to start on cost[0],
and only step on 1s, skipping cost[3].

Your Task:
The task is to complete the function minCostClimbingStairs() which takes an array cost[] as input and returns the minimum cost to reach the top.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] a = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(a, a.length));
    }

    static int minCostClimbingStairs(int[] cost, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(minCostClimbingStairs(dp, cost, n - 2), minCostClimbingStairs(dp, cost, n - 1));
    }

    static int minCostClimbingStairs(int[] dp, int[] cost, int n) {
        if (n == 0)
            return cost[0];
        if (n == 1)
            return cost[1];
        if (dp[n] == -1)
            dp[n] = cost[n] + Math.min(minCostClimbingStairs(dp, cost, n - 2), minCostClimbingStairs(dp, cost, n - 1));
        return dp[n];
    }
}
