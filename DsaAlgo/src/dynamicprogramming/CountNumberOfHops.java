package dynamicprogramming;

import java.util.Arrays;

/*
A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top of Nth step. As the answer will be large find the answer modulo 1000000007.

Example 1:

Input:
N = 1
Output: 1
Example 2:

Input:
N = 4
Output: 7
Explanation:Below are the 7 ways to reach
4
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Your Task:
Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 */
public class CountNumberOfHops {
    public static void main(String[] args) {
        System.out.println(countWays(4));
    }

    static long countWays(int n) {
        long[] a = new long[n + 1];
        Arrays.fill(a, -1);
        return count(n, a);
    }

    static long count(int n, long[] a) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (a[n] == -1)
            a[n] = (count(n - 1, a) % 1000000007 + count(n - 2, a) % 1000000007 + count(n - 3, a) % 1000000007) % 1000000007;
        return a[n];
    }
}
