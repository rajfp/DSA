package bitmagic;
/*
Given an array of integers arr[] of length N, every element appears thrice except for one which occurs once.
Find that element which occurs once.

Example 1:

Input:
N = 4
arr[] = {1, 10, 1, 1}
Output:
10
Explanation:
10 occurs once in the array while the other
element 1 occurs thrice.
Example 2:

Input:
N = 10
arr[] = {3, 2, 1, 34, 34, 1, 2, 34, 2, 1}
Output:
3
Explanation:
All elements except 3 occurs thrice in the array.
Your Task:
You do not need to take any input or print anything. You task is to complete the function singleElement() which takes an array of integers arr and an integer N which finds and returns the element occuring once in the array.

Constraints:
1 ≤ N ≤ 105
-109 ≤ A[i] ≤ 109

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 */
public class FindElementOccuringOnceWhenAllThrice {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 34, 34, 1, 2, 34, 2, 1};
        System.out.println(singleElement(a, a.length));
    }

    static int singleElement(int[] a, int n) {
        int res = 0;
        int x;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            x = 1 << i;
            for (int j = 0; j < n; j++) {
                if ((a[j] & x) != 0)
                    sum++;
            }
            if (sum % 3 != 0)
                res |= x;
        }
        return res;
    }

}
