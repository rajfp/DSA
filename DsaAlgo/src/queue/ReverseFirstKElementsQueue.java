package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Note: The above operations represent the general processings. In-built functions of the respective languages can be used to solve the problem.

Example 1:

Input:
5 3
1 2 3 4 5
Output:
3 2 1 4 5
Explanation:
After reversing the given
input from the 3rd position the resultant
output will be 3 2 1 4 5.
Example 2:

Input:
4 4
4 3 2 1
Output:
1 2 3 4
Explanation:
After reversing the given
input from the 4th position the resultant
output will be 1 2 3 4.
Your Task:
Complete the provided function modifyQueue() that takes queue and K as parameters and returns a modified queue. The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxiliary Space : O(K)
 */
public class ReverseFirstKElementsQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);
        System.out.println(modifyQueue(q, 3));
    }

    static public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Queue<Integer> q2 = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        int i = size - k;
        while (k > 0) {
            s.add(q.poll());
            k--;
        }
        while (i > 0) {
            q2.add(q.poll());
            i--;
        }

        while (!s.isEmpty())
            q.add(s.pop());

        while (!q2.isEmpty())
            q.add(q2.poll());

        return q;
    }
}
