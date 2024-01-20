package recursion;

import java.util.ArrayList;

/*
Given a positive integer N, return the Nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
The elements can be large so return it modulo 109 + 7.

Example 1:

Input:
N = 4
Output:
1 3 3 1
Explanation:
4th row of pascal's triangle is 1 3 3 1.
Example 2:

Input:
N = 5
Output:
1 4 6 4 1
Explanation:
5th row of pascal's triangle is 1 4 6 4 1.
Your Task:
Complete the function nthRowOfPascalTriangle() which takes n, as input parameters and returns an array representing the answer. You don't to print answer or take inputs.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)


 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(nthRowOfPascalTriangle(6));
    }

    static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        if (n == 1) {
            ArrayList<Long> list = new ArrayList<>();
            list.add(1L);
            return list;
        }
        final long MOD = 1000_000_007;
        ArrayList<Long> res = new ArrayList<>();
        res.add(1L);
        ArrayList<Long> list = nthRowOfPascalTriangle(n - 1);
        for (int i = 1; i < n - 1; i++) {
            res.add((list.get(i - 1) + list.get(i)) % MOD);
        }
        res.add(1L);
        return res;
    }
}
