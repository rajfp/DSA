package bitmagic;

/*
Given an integer N. The task is to return the position of first set bit found from the right side in the binary representation of the number.
Note: If there is no set bit in the integer N, then return 0 from the function.

Example 1:

Input:
N = 18
Output:
2
Explanation:
Binary representation of 18 is 010010,the first set bit from the right side is at position 2.
Example 2:

Input:
N = 12
Output:
3
Explanation:
Binary representation of  12 is 1100, the first set bit from the right side is at position 3.
Your Task:
The task is to complete the function getFirstSetBit() that takes an integer n as a parameter and returns the position of first set bit.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).
 */
public class FindFirstSetBit {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-4));
    }

    public static int getFirstSetBit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            if ((n & 1) == 1)
                return count;
            n = n >> 1;
        }
        return count;
    }

}
/*
  public static int getFirstSetBit(int n)
    {
        if(n==0)
            return 0;

        //doing AND operation of n and -n. n and -n will have similar
        //bits only till the first set bit starting from the right
        //and differnt bits after the first set bit.Then we take
        //log2 of the result to find the position.

        //we add 1 to obtained value so that count starts from 1 instead of 0.

        return (int)(Math.log(n&-n)/Math.log(2.0)) + 1;
    }
 */
