package array;

/*
Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with a positive number and 0 (zero) should be considered a positive element.


Example 1:

Input:
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
Explanation : Positive elements : 9,4,5,0,2
Negative elements : -2,-1,-5,-3
As we need to maintain the relative order of
postive elements and negative elements we will pick
each element from the positive and negative and will
store them. If any of the positive and negative numbers
are completed. we will continue with the remaining signed
elements.The output is 9,-2,4,-1,5,-5,0,-3,2.

Example 2:

Input:
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0
Explanation : Positive elements : 5,2,4,7,1,8,0
Negative elements : -5,-2,-8
As we need to maintain the relative order of
postive elements and negative elements we will pick
each element from the positive and negative and will
store them. If any of the positive and negative numbers
are completed. we will continue with the remaining signed
elements.The output is 5,-5,2,-2,4,-8,7,1,8,0.
Your Task:

You don't need to read input or print anything. Your task is to complete the function rearrange() which takes the array of integers arr[] and n as parameters. You need to modify the array itself.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 */
public class AlternateNegativeAndPositive {
    void rearrange(int a[], int n) {
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0)
                pos++;
        }
        int[] posArr = new int[pos];
        int[] negArr = new int[n - pos];
        int i = 0, j = 0, k = 0;
        while (i < n) {
            if (a[i] >= 0)
                posArr[j++] = a[i];
            else
                negArr[k++] = a[i];
            i++;
        }
        i = 0;
        j = 0;
        k = 0;
        while (i < posArr.length && j < negArr.length) {
            a[k++] = posArr[i];
            i++;
            a[k++] = negArr[j];
            j++;
        }
        while (i < posArr.length) {
            a[k++] = posArr[i];
            i++;
        }
        while (j < negArr.length) {
            a[k++] = negArr[j];
            j++;
        }
    }
}
