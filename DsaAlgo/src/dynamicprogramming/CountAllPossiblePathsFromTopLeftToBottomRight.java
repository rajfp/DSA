package dynamicprogramming;

/*
The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints that from each cell you can either move only to right or down.

Example 1:

Input: m = 2, n = 2
Output: 2
Explanation: Two possible ways are
RD and DR.

Example 2:

Input: m = 3, n = 3
Output: 6
Explanation: Six possible ways are
RRDD, DDRR, RDDR, DRRD, RDRD, DRDR.

Your Task:
You dont need to read input or print anything. Complete the function numberOfPaths() which takes m and n as input parameter and returns count all the possible paths.The answer may be very large, compute the answer modulo 109 + 7.


Expected Time Complexity: O(m*n)
Expected Auxiliary Space: O(m*n)
 */
public class CountAllPossiblePathsFromTopLeftToBottomRight {
    public static void main(String[] args) {
        System.out.println(numberOfPaths(3, 3));
    }

    static long numberOfPaths(int m, int n) {
        long[][] a = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = -1;
            }
        }
        return numberOfPaths(a, m - 1, n - 1);
    }

    static long numberOfPaths(long[][] a, int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;
        if (a[m][n] == -1)
            a[m][n] = (numberOfPaths(a, m - 1, n)% 1000000007 + numberOfPaths(a, m, n - 1)% 1000000007)% 1000000007;
        return a[m][n];
    }
}
