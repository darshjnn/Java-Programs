// Cycle Detection for DIRECTED GRAPH

package Graph;

import java.util.*;

public class CycleDetectionDirected {
    static class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    // Unweighted Directed Graph
    public static void unweighted(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    // Check for cycle in Directed Graph
    // Time Complexity : O(V+E)
    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], boolean rec[], int curr) {
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.destination]) {
                return true;
            } 
            else if (!vis[e.destination]) {
                if (isCycleDirected(graph, vis, rec, e.destination)) {
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {

        /*
        Given Directed Graph:
            1 ----> 0 <--- 3 <-
                    |         |
                    |         |
                    --> 2 -----
        */

        // int V = 4;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // unweighted(graph);

        // For Connected Directed Graph
        // System.out.println(isCycleDirected(graph, new boolean[V], new boolean[V], 1));

        // For Disconnected Directed Graph
        // boolean vis[] = new boolean[V];
        // boolean rec[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        //     if (!vis[i]) {
        //         boolean isCycle = isCycleDirected(graph, vis, rec, i);
        //         if (isCycle) {
        //             System.out.println(isCycle);
        //             break;
        //         }
        //     }
        // }
    }
}
