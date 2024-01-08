package strings;

/*
Given a text and a pattern, the task is to check if the pattern exists in the text or not.

Example 1:

Input: text = "geeksforgeeks"
       pat = "geek"
Output: 1
Explanation: "geek" exists in
"geeksforgeeks"
Example 2:

Input: text = "geeksforgeeks"
pat = "gfg"
Output: 0
Explanation: "gfg" does not exists in
"geeksforgeeks"
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string two strings as inputs and returns 1 if the pattern is found, otherwise 0.

Expected Time Complexity: O(|text| + |pat|)
Expected Auxiliary Space: O(|text| + |pat|)
 */
public class PatternSearching {
    int search(String text, String pat) {
        return (text.lastIndexOf(pat) != -1) ? 1 : 0;
    }
}
