package dynamicprogramming;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class CoinChangeLeetCode {
    public int coinChange(int[] coins, int sum) {
        if (sum == 0)
            return 0;
        int[][] a = new int[coins.length][sum + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                a[i][j] = -1;
            }
        }
        int count = count(a, coins, coins.length, sum);
        return (count >= 100000) ? -1 : count - 1;
    }

    public int count(int[][] a, int[] coins, int n, int sum) {
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
