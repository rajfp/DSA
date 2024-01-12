package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        reverse(q);
    }

    static void reverse(Queue<Integer> queue){
        if(queue.isEmpty())
            return;
        int x = queue.poll();
        reverse(queue);
        queue.add(x);
    }
}
