package strings;

import java.util.Arrays;

/*
Given a string S, find the length of the longest substring with all distinct characters.

Example 1:

Input:
S = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest
substring with all distinct characters.
Example 2:

Input:
S = "aaa"
Output: 1
Explanation: "a" is the longest substring
with all distinct characters.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestSubstrDitinctChars() which takes the string S as input and returns the length of the longest substring with all distinct characters.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(K), where K is Constant.
 */

public class LongestSubstrDistinctChars {
    public static void main(String[] args) {
        System.out.println(longestSubstrDistinctChars("qwertyuioplkjh"));
    }

    static int longestSubstrDistinctChars(String s) {

        int[] a = new int[256];
        Arrays.fill(a, -1);
        int count = 0;
        int max = 1, i = 0;
        while (i < s.length()) {
            if (a[s.charAt(i)] == -1) {
                a[s.charAt(i)] = i;
                count++;
                i++;
            } else {
                max = Math.max(max, count);
                System.out.println(max);
                i = a[s.charAt(i)] + 1;
                Arrays.fill(a, -1);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
