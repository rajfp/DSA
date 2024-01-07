package strings;

import java.util.Arrays;

/*
Given a string str and another string patt. Find the minimum index of the character in str that is also present in patt.


Example 1:

Input:
str = geeksforgeeks
patt = set
Output: 1
Explanation: e is the character which is
present in given str "geeksforgeeks"
and is also present in patt "set". Minimum
index of e is 1.
Example 2:

Input:
str = adcffaet
patt = onkl
Output: -1
Explanation: There are none of the
characters which is common in patt
and str.

Your Task:
You only need to complete the function minIndexChar() that returns the index of answer in str or returns -1 in case no character of patt is present in str.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).
 */
public class MinIndexChar {
    public static int minIndexChar(String str, String patt)
    {
        int[] a =new int[256];
        int min = Integer.MAX_VALUE;
        Arrays.fill(a,-1);
        for(int i=0;i<str.length();i++){
            if(a[str.charAt(i)] == -1)
                a[str.charAt(i)] = i;
        }
        for(int i = 0;i<patt.length();i++){
            if(a[patt.charAt(i)]!=-1)
                min = Math.min(min,a[patt.charAt(i)]);
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}
