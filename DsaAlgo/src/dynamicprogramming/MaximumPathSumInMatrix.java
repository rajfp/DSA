package dynamicprogramming;

import java.util.Arrays;

/*
Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].

Matrix [r+1] [c]
Matrix [r+1] [c-1]
Matrix [r+1] [c+1]
Starting from any column in row 0 return the largest sum of any of the paths up to row N-1.

NOTE: We can start from any column in zeroth row and can end at any column in (N-1)th row.

Example 1:

Input: N = 2
Matrix = {{348, 391},
          {618, 193}}
Output: 1009
Explanation: The best path is 391 -> 618.
It gives the sum = 1009.

Example 2:

Input: N = 2
Matrix = {{2, 2},
          {2, 2}}
Output: 4
Explanation: No matter which path is
chosen, the output is 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maximumPath() which takes the size N and the Matrix as input parameters and returns the highest maximum path sum.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


 */
public class MaximumPathSumInMatrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{348, 391},
                {618, 193}};
        System.out.println(maximumPath(2, a));
    }

    static int maximumPath(int n, int[][] a) {
        int[][] dp = new int[n][n];
        System.arraycopy(a[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dp[i][j] = a[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
                else if (j < n - 1)
                    dp[i][j] = a[i][j] + Math.max(dp[i - 1][j], Math.max(dp[i - 1][j + 1], dp[i - 1][j - 1]));
                else
                    dp[i][j] = a[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        int max = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (dp[n - 1][i] > max)
                max = dp[n - 1][i];
        }
        return max;
    }
}
