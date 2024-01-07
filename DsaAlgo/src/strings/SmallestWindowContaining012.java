package strings;

import java.util.Arrays;

/*
Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

Example 1:

Input:
S = 10212
Output:
3
Explanation:
The substring 102 is the smallest substring
that contains the characters 0, 1 and 2.
Example 2:

Input:
S = 12121
Output:
-1
Explanation:
As the character 0 is not present in the
string S, therefor no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
Your Task:
Complete the function smallestSubstring() which takes the string S as input, and returns the length of the smallest substring of string S that contains all the three characters 0, 1 and 2.

Expected Time Complexity: O( length( S ) )
Expected Auxiliary Space: O(1)
 */
public class SmallestWindowContaining012 {
    public static void main(String[] args) {
        System.out.println(smallestSubstring("12121"));
    }
    private static int smallestSubstring(String s) {
        int[] a = new int[3];
        Arrays.fill(a, -1);
        int i = 0;
        int min = Integer.MAX_VALUE;

        while (i < s.length() && ((a['0'-'0'] == -1) || (a['1'-'0'] == -1) || (a['2'-'0'] == -1))) {
            a[s.charAt(i)-'0'] = i;
            i++;
        }
        if (i == s.length() && ((a['0'-'0'] == -1) || (a['1'-'0'] == -1) || (a['2'-'0'] == -1)))
            return -1;
        min = getMin(a['0'-'0'], a['1'-'0'], a['2'-'0']);
        while (i < s.length()) {
            a[s.charAt(i)-'0'] = i;
            min = Math.min(min, getMin(a['0'-'0'], a['1'-'0'], a['2'-'0']));
            i++;
        }
        return min;
    }

    private static int getMin(int x, int y, int z) {
        if (x > y && x > z) {
            if (y > z)
                return x - z + 1;
            else
                return x - y + 1;
        } else if (y > x && y > z) {
            if (x > z)
                return y - z + 1;
            else
                return y - x + 1;
        } else if (z > y && z > x) {
            if (y > x)
                return z - x + 1;
            else
                return z - y + 1;
        }
        return 0;
    }
}
/*
class Solution {
    public int smallestSubstring(String S) {
        // Set a flag to check if an answer exists
        boolean answerExist = false;

        // Initialize variables to keep track of the last positions
        int lastZero = -1, lastOne = -1, lastTwo = -1;

        // Initialize the answer length to be the length of the input string
        int ans = S.length();

        // Iterate through each character in the input string
        for (int i = 0; i < S.length(); i++) {
            // Update the last positions based on the current character
            if (S.charAt(i) == '0') {
                lastZero = i;
            } else if (S.charAt(i) == '1') {
                lastOne = i;
            } else {
                lastTwo = i;
            }

            // Check if all three positions have been updated
            if (lastZero != -1 && lastOne != -1 && lastTwo != -1) {
                // Set the flag to indicate that an answer exists
                answerExist = true;

                // Calculate the length of the substring and update the answer length
                ans = Math.min(
                    ans,
                    1 + i - Math.min(lastZero, Math.min(lastOne, lastTwo)));
            }
        }

        // Check if an answer exists and return the final answer
        if (answerExist) {
            return ans;
        }
        return -1;
    }
};
 */
