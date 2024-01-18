package Graph;

import java.util.*;

public class Graphs {
    static class Edge {
        int source;
        int destination;
        int weight;
        
        //Undirected Unweighted Graph
        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
        
        //Undirected Weighted Graph
        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    
    // Create an Undirected Unweighted Graph
    static void unweightGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0, 2));
        
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }
    
    // Create an Undirected Weighted Graph
    static void weightGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0, 2, 2));
        
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));
        
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));
        
        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }
    
    public static void main(String[] args) {
        // int vertices = 4;
        // ArrayList<Edge> graph[] = new ArrayList[vertices];
        // unweightGraph(graph);
        
        // //Print neighbour's of any vertex
        // for (int i = 0; i < graph[2].size(); i++) {
        //     Edge e = graph[2].get(i);
        //     System.out.print(e.destination + " ");
        // }
        
        // weightGraph(graph);
        // System.out.println();
        // //Print weight neighbour's of any vertex
        // for (int i = 0; i < graph[2].size(); i++) {
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.destination + " " + e.weight);
        // }
    }
}
