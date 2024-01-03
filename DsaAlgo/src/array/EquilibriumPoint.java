package array;

/*
Given an array A of n positive numbers. The task is to find the first equilibrium point in an array. Equilibrium point in an array is an index (or position) such that the sum of all elements before that index is same as sum of elements after it.

Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists.

Example 1:

Input:
n = 5
A[] = {1,3,5,2,2}
Output:
3
Explanation:
equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2).
Example 2:

Input:
n = 1
A[] = {1}
Output:
1
Explanation:
Since there's only element hence its only the equilibrium point.
Your Task:
The task is to complete the function equilibriumPoint() which takes the array and n as input parameters and returns the point of equilibrium.
 */
public class EquilibriumPoint {
    public static int equilibriumPoint(long a[], int n) {
        if(n==1) return 1;
        long lSum = a[0];
        long rSum = a[n-1];
        int i=0,j=n-1;
        while(i<j){
            if(lSum > rSum){
                rSum+=a[--j];
            }
            else if(lSum < rSum){
                lSum+=a[++i];
            }
            else if(j-i ==2 && lSum == rSum)
                return i+2;
            else{
                rSum+=a[--j];
                lSum+=a[++i];
            }
        }
        return -1;
    }
}
/*
Editorial

public static int equilibriumPoint(long a[], int n) {

        //We store the sum of all array elements.
        long sum = 0;
        for (int i = 0; i < n; i++)
           sum += a[i];

        //sum2 is used to store prefix sum.
        long sum2 = 0;

        for (int i = 0; i < n; i++) {

            //Leaving out the value of current element from suffix sum.
            sum = sum - a[i];

            //Checking if suffix and prefix sums are same.
            if (sum2 == sum) {
                //returning the index or equilibrium point.
                return (i + 1);
            }

            //Adding the value of current element to prefix sum.
            sum2 = sum2 + a[i];
        }
        return -1;
    }
 */
