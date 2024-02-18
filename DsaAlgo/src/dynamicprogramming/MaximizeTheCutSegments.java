package dynamicprogramming;

import java.util.Arrays;

/*
Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.

Note: if no segment can be cut then return 0.

Example 1:

Input:
N = 4
x = 2, y = 1, z = 1
Output: 4
Explanation:Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.
Example 2:

Input:
N = 5
x = 5, y = 3, z = 2
Output: 2
Explanation: Here total length is 5, and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.
Your Task:
You only need to complete the function maximizeTheCuts() that takes n, x, y, z as parameters and returns max number cuts.

Expected Time Complexity : O(N)
Expected Auxiliary Space: O(N)
 */
public class MaximizeTheCutSegments {
    public static void main(String[] args) {
        System.out.println(maximizeCuts(100, 23, 15, 50));
    }

    static public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int maxCuts = maximizeCuts(dp, n, x, y, z);
        return maxCuts <= 0 ? 0 : maxCuts - 1;
    }

    static public int maximizeCuts(int[] dp, int n, int x, int y, int z) {
        if (n == 0)
            return 1;
        if (n < Math.min(x, Math.min(y, z)))
            return Integer.MIN_VALUE;
        if (dp[n] == -1)
            dp[n] = 1 + Math.max(maximizeCuts(dp, n - x, x, y, z), Math.max(maximizeCuts(dp, n - y, x, y, z), maximizeCuts(dp, n - z, x, y, z)));
        return dp[n];
    }

    static public int maxCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];

        if (n == 0)
            return 1;
        if (n < Math.min(x, Math.min(y, z)))
            return Integer.MIN_VALUE;
        if (dp[n] == -1)
            dp[n] = 1 + Math.max(maximizeCuts(dp, n - x, x, y, z), Math.max(maximizeCuts(dp, n - y, x, y, z), maximizeCuts(dp, n - z, x, y, z)));
        return dp[n];
    }
}
