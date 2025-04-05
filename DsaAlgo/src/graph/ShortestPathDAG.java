package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathDAG {

    public static void main(String[] args) {

        shortestPath(10, 24, new int[][]{
                {0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6},
        });
    }

    static public int[] shortestPath(int n, int m, int[][] edges) {

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++)
            graph.addEdge(edges[i][0], edges[i][1], edges[i][2]);
        int[] top = topoSort(n, graph.getAdjList());
        /*
        we do not need to make an array here we can use directly stack
         */
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int j : top) {
            for (AdjListNode node : graph.getAdjList().get(j)) {
                if (dist[j] != Integer.MAX_VALUE && (dist[node.getValue()] > dist[j] + node.getWeight()))
                    /*
                    dist[j] != Integer.MAX_VALUE is necessary because dist[j] + node.getWeight() will cross integer limit
                    and turn negative which will result in true condition and wrong answer.
                     */
                    dist[node.getValue()] = dist[j] + node.getWeight();
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }


    static public int[] topoSort(int n, ArrayList<ArrayList<AdjListNode>> adjList) {

        int[] topoSort = new int[n];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adjList);
            }
        }
        while (!stack.isEmpty()) {
            topoSort[k++] = stack.pop();
        }
        return topoSort;
    }

    static private void dfs(int u, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<AdjListNode>> adjList) {
        visited[u] = true;
        ArrayList<AdjListNode> list = adjList.get(u);
        for (AdjListNode node : list) {
            if (!visited[node.getValue()]) {
                dfs(node.getValue(), visited, stack, adjList);
            }
        }
        stack.push(u);
    }


}

class AdjListNode {
    private int value;
    private int weight;

    public AdjListNode(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Graph {


    private int v;
    private ArrayList<ArrayList<AdjListNode>> adjList;

    public ArrayList<ArrayList<AdjListNode>> getAdjList() {
        return adjList;
    }

    Graph(int v) {
        this.v = v;
        adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new AdjListNode(v, weight));
    }

}
