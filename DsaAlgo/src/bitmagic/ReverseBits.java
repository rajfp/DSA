package bitmagic;
/*
Given a 32 bit number X, reverse its binary form and print the answer in decimal.

Example 1:

Input:
X = 1
Output:
2147483648
Explanation:
Binary of 1 in 32 bits representation-
00000000000000000000000000000001
Reversing the binary form we get,
10000000000000000000000000000000,
whose decimal value is 2147483648.
Example 2:

Input:
X = 5
Output:
2684354560
Explanation:
Binary of 5 in 32 bits representation-
00000000000000000000000000000101
Reversing the binary form we get,
10100000000000000000000000000000,
whose decimal value is 2684354560.
Your Task:
You don't need to read input or print anything. Your task is to complete the function reversedBits() which takes an Integer X as input and returns the answer.

Expected Time Complexity: O(log(X))
Expected Auxiliary Space: O(1)
 */
public class ReverseBits {
    /*
    public int reverseBits(int n) {
        int rev = 0;
        for(int i = 0;i < 32 && n != 0;i++){
            rev = rev | ((1 & n) << (31 - i));
            n = n >> 1;
        }
        return rev;
    }
     */
    public static void main(String[] args) {
        System.out.println(reversedBits(7L));
    }

    static Long reversedBits(Long x) {
        int i = 0;
        Long res = 0L;
        while (i < 32) {
            if ((x & (1L << i)) != 0)
                res = (res << 1) | 1;
            else
                res = res << 1;
            i++;
        }
        return res;
    }
}
