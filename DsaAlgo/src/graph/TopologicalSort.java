package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    int[] topologicalSort(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] inDegree = new int[v];
        int[] topSort = new int[v];
        for (int i = 0; i < v; i++) {
            for (int u : adj.get(i))
                inDegree[u]++;
        } /*  O(V+E)*/
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        /*  O(V+E)*/
        int i=0;
        while (!q.isEmpty()) {

            int curr = q.poll();
            topSort[i++] = curr;
            for (int u : adj.get(curr)) {
                inDegree[u]--;
                if (inDegree[u] == 0)
                    q.add(u);
            }
        }
        return topSort;
    }
}
