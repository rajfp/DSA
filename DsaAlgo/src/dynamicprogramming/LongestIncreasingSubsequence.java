package dynamicprogramming;

/*
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output:
6
Explanation:
There are more than one LIS in this array. One such Longest increasing subsequence is {0,2,6,9,13,15}.
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output:
3
Explanation:
There are more than one LIS in this array.  One such Longest increasing subsequence is {5,7,9}.
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( NlogN )
Expected Auxiliary Space: O(N)
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(longestSubsequence(a.length, a));
    }

    /*
    O(N*N)
     */
    //    static int longestSubsequence(int size, int[] a) {
//        int[] lis = new int[size];
//        lis[0] = 1;
//        for (int i = 1; i < size; i++) {
//            lis[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (a[j] < a[i])
//                    lis[i] = Math.max(lis[i], lis[j] + 1);
//            }
//        }
//        int max = lis[0];
//        for (int i : lis)
//            max = Math.max(max, i);
//        return max;
//    }
   /*
   O(NlogN)
    */
    static int longestSubsequence(int size, int[] a) {
        int[] lis = new int[size];
        lis[0] = a[0];
        int j = 1;
        int i = 0;
        while (j < size) {
            if (a[j] > lis[i]) {
                lis[++i] = a[j];
            } else {
                int ceil = ceil(lis, 0, i, a[j]);
                lis[ceil] = a[j];
            }
            j++;
        }
        return ++i;
    }

    static int ceil(int[] a, int start, int end, int x) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] >= x)
                end = mid - 1;
            else if (a[mid] < x) {
                start = mid + 1;
            }
        }
        return start;
    }
}
