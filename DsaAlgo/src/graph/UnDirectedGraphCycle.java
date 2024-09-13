package graph;

import java.util.ArrayList;

public class UnDirectedGraphCycle {
    boolean checkIfUndirectedCyclicGraph(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (checkIfCyclicGraph(adj, i, visited, -1))
                    return true;
            }
        }
        return false;
    }

    private boolean checkIfCyclicGraph(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {

        visited[s] = true;
        for (int v : adj.get(s)) {
            if (!visited[v]) {
                if(checkIfCyclicGraph(adj,v,visited,s))
                    return true;
            } else if (v != parent)
                return true;
        }
        return false;
    }
}

