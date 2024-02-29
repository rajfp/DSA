package dynamicprogramming;

import java.util.Arrays;

/*
Given a number N. Find the minimum number of squares of any number that sums to N. For Example: If N = 100 , N can be expressed as (10*10) and also as (5*5 + 5*5 + 5*5 + 5*5) but the output will be 1 as minimum number of square is 1 , i.e (10*10).


Example 1:

Input: N = 100
Output: 1
Explanation: 10 * 10 = 100
Example 2:

Input: N = 6
Output: 3
Explanation = 1 * 1 + 1 * 1 + 2 * 2 = 6


Your Task:
You don't need to read or print anything. Your task is to complete the function MinSquares() which takes N as input parameter and returns minimum number of squares needed to make N.


Expected Time Complexity: O(N * sqrt(N) )
Expected Space Complexity: O(N)
 */
public class GetMinimumSquares {
    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(minSquares(n));
    }

    //    static int minSquares(int[] dp, int n) {
//        if (n == 0)
//            return 0;
//        if (dp[n] == -1) {
//            int ans = n;
//            for (int i = 1; i * i <= n; i++) {
//                ans = Math.min(ans, 1 + minSquares(dp, n - (i * i)));
//            }
//            dp[n] = ans;
//        }
//        return dp[n];
//    }
    static int minSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int ans = i;
            for (int j = 1; j * j <= i; j++) {
                ans = Math.min(ans, dp[i - (j * j)]);
            }
            dp[i] = 1 + ans;
        }
        return dp[n];
    }
}
