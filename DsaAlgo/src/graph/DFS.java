package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static void addEdge(List<List<Integer>> list, int s, int t) {
        list.get(s).add(t);
        list.get(t).add(s);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}};
        for (int[] x : edges) {
            addEdge(adj, x[0], x[1]);
        }
        dfs(adj,1,new boolean[5]);
    }


    static void dfs(List<List<Integer>> list, int source, boolean[] visited) {
        if (visited[source])
            return;
        visited[source] = true;
        System.out.print(source + " ");
        for (int i : list.get(source))
            dfs(list, i, visited);
    }
}
/*
Time complexity : O(V+E)
Space complexity : O(V+E)
 */
