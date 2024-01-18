// Depth First Traversal is similar to recursive traversal (i.e. Inorder, Preorder & Postorder)
// Time Complexity = O(V+E)
// In DFS, keep going to the first neighbour

package Graph;

import java.util.*;

public class GraphDFS {
    static class Edge{
        int source;
        int destination;
        
        Edge (int source, int destination) {
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
    
    // DFS Traversal
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) { 
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.destination] == false) {
                dfs(graph, e.destination, vis);
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
        
        // int V = 7;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // unweightGraph(graph);
        // boolean vis[] = new boolean[V];
        // dfs(graph, 0, vis);

        // DFS for Disconnected Graphs
        // for (int i = 0; i < V; i++) {
        //     if (vis[i] == false) {
        //         dfs(graph, i, vis);
        //     }
        // }
    }
}
