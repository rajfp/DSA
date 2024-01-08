package strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Given a list of N words. Count the number of words that appear exactly twice in the list.

Example 1:

Input:
N = 3
list = {Geeks, For, Geeks}
Output: 1
Explanation: 'Geeks' is the only word that
appears twice.
Example 2:

Input:
N = 8
list = {Tom, Jerry, Thomas, Tom, Jerry,
Courage, Tom, Courage}
Output: 2
Explanation: 'Jerry' and 'Courage' are the
only words that appears twice.

Your Task:
You dont need to read input or print anything. Complete the function countWords() which takes integer N and list of strings as input parameters and returns the number of words that appear twice in the list.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 */
public class CountWords {
    public int countWords(String list[], int n) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int count=0;
        for (String i : list) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else
                map.put(i, map.get(i) + 1);
        }

        for (Map.Entry<String, Integer> i : map.entrySet()) {
            if(i.getValue() == 2)
                count++;
        }
        return count;
    }
}
