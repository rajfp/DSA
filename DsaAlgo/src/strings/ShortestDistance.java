package strings;

import java.util.ArrayList;

/*
Given a list of words followed by two words, the task to find the minimum distance between the given two words in the list of words


Example 1:

Input:
S = { "the", "quick", "brown", "fox",
     "quick"}
word1 = "the"
word2 = "fox"
Output: 3
Explanation: Minimum distance between the
words "the" and "fox" is 3
Example 2:

Input:
S = {"geeks", "for", "geeks", "contribute",
     "practice"}
word1 = "geeks"
word2 = "practice"
Output: 2
Explanation: Minimum distance between the
words "geeks" and "practice" is 2

Your Task:
You don't need to read input or print anything. Your task is to complete the function

shortestDistance() which list of words, two strings as inputs and returns the minimum distance between two words

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)
 */
public class ShortestDistance {

    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int indexOfFirst = -1;
        int indexOfSecond = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).equals(word1)) {
                indexOfFirst = i;
                if (indexOfSecond != -1)
                    min = Math.min(min, Math.abs(indexOfFirst - indexOfSecond));
            } else if (s.get(i).equals(word2)) {
                indexOfSecond = i;
                if (indexOfFirst != -1)
                    min = Math.min(min, Math.abs(indexOfFirst - indexOfSecond));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
