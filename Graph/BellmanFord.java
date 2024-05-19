/*
Bellman Ford algorithm works even for the cases where Dijkstra's Algorithm fails, i.e. for negative
weights of the edges.
It uses Dynamic Programming.
Time complexity of Bellman Ford Algorithm is more than Dijkstra Algorithm.
Time Complexity is O(E.V)
Bellman Ford fails for negative destination cycles, i.e. when total destination of graph cycle is negative.
 */

package Graph;

import java.util.*;

public class BellmanFord {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static void bellmanFord(ArrayList<Edge>[] graph, int source, int V) {
        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != source) {
                dis[i] = Integer.MAX_VALUE;
            }
        }

//      Time Complexity of Outer most loop: O(V)
        for (int k = 0; k < (V - 1); k++) {
//          Time Complexity of inner loop: O(E)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;
                    if (dis[u] != Integer.MAX_VALUE && (dis[u] + e.weight) < dis[v]) {
                        dis[v] = dis[u] + e.weight;
                    }
                }
            }
        }

//      Detect Negative destination cycle
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.source;
                int v = e.destination;
                if (dis[u] != Integer.MAX_VALUE && (dis[u] + e.weight) < dis[v]) {
                    System.out.println("Negative Weight Cycle");
                }
            }
        }

        for (int di : dis) {
            System.out.print(di + " ");
        }
        System.out.println();

    }

    private static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -10));
    }

    public static void main(String[] args) {
        int source = 0;
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph, source, V);
    }
}