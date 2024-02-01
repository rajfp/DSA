package greedy;

/*
Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'. Return -1 if it is not possible.

Example 1:

Input: N = 2, S = 9
Output: 90
Explaination: It is the biggest number
with sum of digits equals to 9.
Example 2:

Input: N = 3, S = 20
Output: 992
Explaination: It is the biggest number
with sum of digits equals to 20.
Your Task:
You do not need to read input or print anything. Your task is to complete the function findLargest() which takes N and S as input parameters and returns the largest possible number. Return -1 if no such number is possible.

Expected Time Complexity: O(N)
Exepcted Auxiliary Space: O(1)
 */
public class LargestNumberPossible {
    public static void main(String[] args) {
        System.out.println(findLargest(3, 30));
    }

    static String findLargest(int n, int s) {
        if (s == 0 || (n * 9) < s)
            return "-1";
        StringBuilder num = new StringBuilder();
        while (n > 0) {
            if (s >= 9) {
                num.append("9");
                s -= 9;
            } else if (s > 0) {
                num.append(s);
                s = 0;
            } else if (s == 0) {
                num.append("0");
            }
            n--;
        }
        return num.toString();
    }

}
