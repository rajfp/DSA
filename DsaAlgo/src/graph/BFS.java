package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    static void addEdge(List<List<Integer>> list, int s, int t) {
        list.get(s).add(t);
        list.get(t).add(s);
    }

//    static void bfs(List<List<Integer>> list, int source, boolean[] visited){
//        Queue<Integer> q = new LinkedList<>();
//        q.add(source);
//        while(!q.isEmpty()){
//            int data = q.poll();
//            if(!visited[data]){
//                visited[data] = true;
//                System.out.println(data);
//                for(int x:list.get(data))
//                    q.add(x);
//            }
//        }
//    }
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
        System.out.println(bfs(adj,0,new boolean[5]));
    }
   static ArrayList<Integer> bfs(List<List<Integer>> adj,int source, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        q.add(source);
        while(!q.isEmpty()){
            int data = q.poll();
            if(!visited[data]){
                visited[data] = true;
                list.add(data);
                for(int x:adj.get(data))
                    q.add(x);
            }

        }
        return list;
    }
}

/*
Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
Auxiliary Space: O(V)
 */