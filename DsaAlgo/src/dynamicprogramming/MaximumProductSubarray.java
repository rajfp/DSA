package dynamicprogramming;

/*
Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is [6, -3, -10] which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is [2, 3, 4, 5] which gives product as 120.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
Note: Use 64-bit integer data type to avoid overflow.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 4, 5, -1, 0};
        System.out.println(maxProduct(a, a.length));
    }

    static long maxProduct(int[] a, int n) {
        long minVal = a[0];
        long maxVal = a[0];
        long maxProd = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] < 0) {
                long t = maxVal;
                maxVal = minVal;
                minVal = t;
            }
            maxVal = Math.max(a[i], maxVal * a[i]);
            minVal = Math.min(a[i], minVal * a[i]);
            maxProd = Math.max(maxProd, maxVal);
        }
        return maxProd;
    }
}
/*
Other approach run one loop from left side keep multiplying and store max wherever find 0 reset to 1,
run one loop from right side do same and now max from both loop.
 */
