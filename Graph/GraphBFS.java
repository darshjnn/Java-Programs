// Breadth First Traversal in Graph is similar to Level Order traversal in Tree
// Time Complexity = O(V+E)
// In BFS, go to immediate neighbour first

package Graph;

import java.util.*;

public class GraphBFS {
    static class Edge {
        int source;
        int destination;
        int weight;
        
        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
        
        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    // Unweighted Graph
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
    
    // BFS traversal
    public static void bfs(ArrayList<Edge> graph[], int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0);
        
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;
                
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    //BFS for Disconnected Graph
    public static void bfsDis(ArrayList<Edge> graph[], int V, boolean vis[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).destination);
                }
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
        // ArrayList<Edge> g[] = new ArrayList[V];
        // unweightGraph(g);
        // bfs(g, V);
        // System.out.println();

        // // For Disconnected Graph
        // boolean vis[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        //     if (vis[i] == false) {
        //         bfsDis(g, V, vis, i);
        //     }
        // }
    }
}
