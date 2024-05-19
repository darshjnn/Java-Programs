// Print all paths from Source to Target element
//Time Complexity = O(V^V)

package Graph;

import java.util.*;

public class AllPaths {
    static class Edge{
        int source;
        int destination;
        
        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    
    // Unweighted Undirected Graph
    public static void unweightGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        
        graph[6].add(new Edge(6, 5));
    }
    
    public static void allPaths(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.destination]) {
                vis[curr] = true;
                allPaths(graph, vis, e.destination, path + e.destination, target);
                vis[curr] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        
        /* 
        *   1 --- 3
        *  /      | \
        * 0       |  5 --- 6
        *  \      | /
        *   2 --- 4
        */ 
        
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        unweightGraph(graph);

        
        boolean vis[] = new boolean[V];
        String path = "0";
        allPaths(graph, vis, 0, path, 5);
    }
}
