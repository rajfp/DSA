package recursion;

import java.util.Stack;

/*
Given a stack, delete the middle element of the stack without using any additional data structure.
Middle element:- floor((size_of_stack+1)/2) (1-based indexing) from bottom of the stack.

Note: The output shown by the compiler is the stack from top to bottom.

Example 1:

Input:
Stack = {10, 20, 30, 40, 50}
Output:
ModifiedStack = {10, 20, 40, 50}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 50. Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like {10 20 40 50}.
Example 2:

Input:
Stack = {10 20 30 40}
Output:
ModifiedStack = {10 30 40}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 40. Middle element will be element at index 2 from bottom, which is 20. Deleting 20, stack will look like {10 30 40}.
Your Task:
You don't need to read input or print anything. Complete the function deleteMid() which takes the stack and its size as input parameters and modifies the stack in-place.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


 */
public class DeleteMiddleElementOfStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
//        s.push(20);
//        s.push(30);
//        s.push(40);
//        s.push(50);
        deleteMid(s, s.size());
        System.out.println(s);
    }

    public static void deleteMid(Stack<Integer> s, int sizeOfStack) {
        int k = (s.size() + 1) / 2;
        if ((sizeOfStack % 2 == 0)) {
            ++k;
        }
        delete(s, k, 1);
    }

    public static void delete(Stack<Integer> s, int k, int level) {
        if (level > k) {
            return;
        }
        int x = s.pop();
        delete(s, k, level + 1);
        if (level != k)
            s.push(x);
    }
}
