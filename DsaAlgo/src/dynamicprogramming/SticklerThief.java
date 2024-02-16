package dynamicprogramming;

import java.util.Arrays;

/*
Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. ith house has a[i] amount of money present in it.

Example 1:

Input:
n = 5
a[] = {6,5,5,7,4}
Output:
15
Explanation:
Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6+5+4=15.
Example 2:

Input:
n = 3
a[] = {1,5,3}
Output:
5
Explanation:
Loot only 2nd house and get maximum amount of 5.
Your Task:
Complete the functionFindMaxSum() which takes an array arr[] and n as input which returns the maximum money he can get following the rules.

Expected Time Complexity:O(N).
Expected Space Complexity:O(1).
 */
public class SticklerThief {
    public static void main(String[] args) {
        int[] a = new int[]{9, 10, 5, 7};
        System.out.println(findMaxSum(a, a.length));
    }

    static public int findMaxSum(int[] a, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return findMaxSum(a, n, 0, dp);
    }

    static public int findMaxSum(int[] a, int n, int i, int[] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] == -1) {
            int excluded = findMaxSum(a, n, i + 1, dp);
            int included = a[i] + findMaxSum(a, n, i + 2, dp);
            dp[i] = Math.max(excluded, included);
        }
        return dp[i];
    }
}
