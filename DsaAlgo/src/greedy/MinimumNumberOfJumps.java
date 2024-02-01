package greedy;

/*
Given an array of N integers arr[] where each element represents the maximum length of the jump that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.

Note: Return -1 if you can't reach the end of the array.


Example 1:

Input:
N = 11
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3
Explanation:
First jump from 1st element to 2nd
element with value 3. Now, from here
we jump to 5th element with value 9,
and from here we will jump to the last.
Example 2:

Input :
N = 6
arr = {1, 4, 3, 2, 6, 7}
Output: 2
Explanation:
First we jump from the 1st to 2nd element
and then jump to the last element.

Your task:
You don't need to read input or print anything. Your task is to complete function minJumps() which takes the array arr and it's size N as input parameters and returns the minimum number of jumps. If not possible return -1.


Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


 */
public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{1, 4, 3, 2, 6, 7}));
    }

    static int minJumps(int[] a) {
        if (a.length == 1)
            return 0;
        int currentStep = a[0], maxIdx = 0;
        int i = 0, minJump = 0;
        while (currentStep != 0) {
            minJump++;
            int j = maxIdx + currentStep;
            if (j >= a.length - 1)
                return minJump;
            currentStep = a[j];
            maxIdx = j;
            int jumpVal = j + a[j];
            if (jumpVal >= a.length - 1)
                return ++minJump;
            while (j > i) {
                if ((a[j] + j) > jumpVal) {
                    currentStep = a[j];
                    jumpVal = a[j] + j;
                    maxIdx = j;
                }
                j--;
            }
            i = maxIdx;
        }
        return -1;
    }
}
/*
static int minJumps(int[] arr){
        int mx = 0;
        int n = arr.length
        int curr=0;
        int count = 0;
        for(int i = 0; i< n-1; i++)
        {
            mx = Math.max(mx,arr[i]+i);
            if(i==curr)
            {
                count++;
                curr = mx;
            }
        }
        if(curr >= n-1)
        {
            return count;
        }
        return -1;
    }
 */
