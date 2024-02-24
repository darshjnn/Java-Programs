// Cycle Detection for UNDIRECTED GRAPH

package Graph;

import java.util.*;

public class CycleDetectionUndirected {
    static class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    // Unweighted Undirected Graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    // Check for cycle in Undirected Graph
    // Time Complexity: O(V+E)
    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int parent, int curr) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (vis[e.destination] && e.destination != parent) {
                return true;
            }
            else if (!vis[e.destination]) {
                if (isCycleUndirected(graph, vis, curr, e.destination)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // int V = 6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        // System.out.println(isCycleUndirected(graph, new boolean[V], -1, 0));
    }
}
