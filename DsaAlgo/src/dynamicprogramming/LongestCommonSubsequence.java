package dynamicprogramming;

/*
Given two strings, find the length of longest subsequence present in both of them. Both the strings are in uppercase latin alphabets.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input strings “ABCDGH” and “AEDFHR” is “ADH” of length 3.
Example 2:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is "AC" of length 2.
Your Task:
Complete the function lcs() which takes the length of two strings respectively and two strings as input parameters and returns the length of the longest subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcs(6, 6, "ABCDGH", "AEDFHR"));
    }

    static int lcs(int x, int y, String s1, String s2) {
        int[][] a = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                a[i][j] = -1;
            }
        }
        return lcs(a, x, y, s1, s2);
    }

    static int lcs(int[][] a, int x, int y, String s1, String s2) {
        if (x == 0 || y == 0)
            return 0;
        if (a[x][y] == -1) {
            if (s1.charAt(x - 1) == s2.charAt(y - 1))
                a[x][y] = 1 + lcs(a, x - 1, y - 1, s1, s2);
            else {
                a[x][y] = Math.max(lcs(a, x - 1, y, s1, s2), lcs(a, x, y - 1, s1, s2));
            }
        }
        return a[x][y];
    }
}
