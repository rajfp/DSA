package dynamicprogramming;

import java.util.Arrays;

/*
Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.


Example 1:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1
Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.
Example 2:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 30
Output: 0
Explanation: There is no subset with sum 30.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isSubsetSum() which takes the array arr[], its size N and an integer sum as input parameters and returns boolean value true if there exists a subset with given sum and false otherwise.
The driver code itself prints 1, if returned value is true and prints 0 if returned value is false.


Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum*N)
 */
public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] a = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(a.length - 1, a, 30));
    }

    static Boolean isSubsetSum(int n, int[] a, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return isSubsetSum(dp, n, a, sum) != 0;

    }

    static int isSubsetSum(int[][] dp, int n, int[] a, int sum) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][sum] == -1) {
            if (a[n-1] > sum)
                dp[n][sum] = isSubsetSum(dp, n - 1, a, sum);
            else
                dp[n][sum] = isSubsetSum(dp, n - 1, a, sum - a[n-1]) | isSubsetSum(dp, n - 1, a, sum);
        }
        return dp[n][sum];
    }
}
