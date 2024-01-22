package bitmagic;

/*
Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return in increasing order.

Example 1:

Input:
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4
Explanation:
3 and 4 occur exactly once.
Example 2:

Input:
N = 1
arr[] = {2, 1, 3, 2}
Output:
1 3
Explanation:
1 3 occur exactly once.
Your Task:
You do not need to read or print anything. Your task is to complete the function singleNumber() which takes the array as input parameter and returns a list of two numbers which occur exactly once in the array. The list must be in ascending order.

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)
 */
public class NonRepeatingNumbers {
    public static void main(String[] args) {
        for(int i : singleNumber(new int[]{2,1,3,2}))
            System.out.println(i);
    }
    static public int[] singleNumber(int[] a) {
        int x = 0;
        int[] b = new int[2];
        for (int i : a)
            x ^= i;
        int lastSetBit = x & (-x);
        for (int i : a) {
            if ((i & lastSetBit) == 0)
                b[0] ^= i;
            else
                b[1] ^= i;
        }
        if (b[0] > b[1]) {
            int t = b[0];
            b[0] = b[1];
            b[1] = t;
        }
        return b;
    }
}
