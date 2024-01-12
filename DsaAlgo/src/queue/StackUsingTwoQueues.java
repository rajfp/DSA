package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement a Stack using two queues q1 and q2.

Example 1:

Input:
push(2)
push(3)
pop()
push(4)
pop()
Output: 3 4
Explanation:
push(2) the stack will be {2}
push(3) the stack will be {2 3}
pop()   poped element will be 3 the
        stack will be {2}
push(4) the stack will be {2 4}
pop()   poped element will be 4
Example 2:

Input:
push(2)
pop()
pop()
push(3)
Output: 2 -1
Your Task:

Since this is a function problem, you don't need to take inputs. You are required to complete the two methods push() which takes an integer 'x' as input denoting the element to be pushed into the stack and pop() which returns the integer poped out from the stack(-1 if the stack is empty).

Expected Time Complexity: O(1) for push() and O(N) for pop() (or vice-versa).
Expected Auxiliary Space: O(1) for both push() and pop().
 */
public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int a) {

        if (q1.isEmpty()) {
            q1.add(a);
            return;
        }
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1.add(a);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    int pop() {
        if (!q1.isEmpty())
            return q1.poll();
        return -1;
    }
}
