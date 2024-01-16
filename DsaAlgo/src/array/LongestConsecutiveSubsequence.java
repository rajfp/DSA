package array;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.


Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        System.out.println(findLongestConSeqSubSeq(new int[]{1,9,3,10,4,20,2}, 7));
    }

    static int findLongestConSeqSubSeq(int a[], int n) {
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int curr = 1;
                while (set.contains(i + curr))
                    curr++;
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
