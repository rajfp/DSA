package queue;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.

Example 1:

Input:
N = 2
Output:
1 10
Explanation:
Binary numbers from
1 to 2 are 1 and 10.

Example 2:

Input:
N = 5
Output:
1 10 11 100 101
Explanation:
Binary numbers from
1 to 5 are 1 , 10 , 11 , 100 and 101.


Your Task:
You only need to complete the function generate() that takes N as parameter and returns vector of strings denoting binary numbers.

Expected Time Complexity : O(N log2N)
Expected Auxilliary Space : O(N log2N)
 */
public class GenerateBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(generate(2));
    }
    static ArrayList<String> generate(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(convertToBinary(i));
        }
        return list;
    }

    static String convertToBinary(int n) {
        Stack<Integer> s = new Stack<>();
        while (n != 0) {
            s.push(n % 2);
            n /= 2;
        }
        StringBuilder str = new StringBuilder();
        while (!s.empty()) {
            str.append(s.pop());
        }
        return str.toString();
    }
}
