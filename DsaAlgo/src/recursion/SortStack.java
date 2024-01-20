package recursion;

import java.util.Stack;
/*
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task:
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s.push(11);
        System.out.println(sort(s, s2));
    }

    public static Stack<Integer> sort(Stack<Integer> s, Stack<Integer> s2) {
        if (s.size() == 1)
            return s;
        int x = s.pop();
        Stack<Integer> stack = sort(s, s2);
        while (!stack.isEmpty() && stack.peek() > x)
            s2.push(stack.pop());
        stack.push(x);
        while (!s2.isEmpty())
            stack.push(s2.pop());
        return stack;
    }
}
