package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathDAG {

    public static void main(String[] args) {

    }

    public int[] shortestPath(int n, int m, int[][] edges) {

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++)
            graph.addEdge(edges[i][0], edges[i][1], edges[i][2]);

        int[] top = topoSort(n, graph.getAdjList(), m, edges);
        for (int i : top)
            System.out.print(i + " ");

        return new int[]{};
    }


    public int[] topoSort(int n, LinkedList<AdjListNode>[] adjList, int m, int[][] edges) {

        int[] topoSort = new int[n];
        int[] inDeg = new int[n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            inDeg[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            topoSort[k++] = curr;
            for (AdjListNode item : adjList[curr]) {
                inDeg[item.getValue()]--;
                if (inDeg[item.getValue()] == 0)
                    q.offer(item.getValue());
            }
        }
        return topoSort;
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
}

class Graph {


    private int v;
    private LinkedList<AdjListNode>[] adjList;

    public LinkedList<AdjListNode>[] getAdjList() {
        return adjList;
    }

    Graph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v, int weight) {
        adjList[u].add(new AdjListNode(v, weight));
    }

}
