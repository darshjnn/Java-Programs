/*
Dijkstra's Algorithm: To find the shortest path in Weighted Graph (Directed/ Undirected)
It works on BFS, and it is a Greedy Algorithm
Time Complexity: O(E + E logV), where (E logV) is due to Priority Queue
*/


package Graph;

import java.util.*;

public class Dijkstra {
	static class Edge {
		int source;
		int destination;
		int weight;
		
		Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int node;
		int distance;
		
		Pair(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Pair p2) {
			return this.distance - p2.distance; // For ascending
			// return p2.distance - this.distance; For descending
		}
	}
	
	private static void dijkstra(ArrayList<Edge>[] graph, int source, int V) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[V];
		int[] distance = new int[V];
		
		for (int i = 0; i < V; i++) {
			if (i != source) {
				distance[i] = Integer.MAX_VALUE;
			}
		}
		
		pq.add(new Pair(source, 0));
		
		// BFS
		while (!pq.isEmpty()) {
			Pair curr = pq.remove();
			if (!vis[curr.node]) {
				vis[curr.node] = true;
				
				for (int i = 0; i < graph[curr.node].size(); i++) {
					Edge e = graph[curr.node].get(i);
					int u = e.source;
					int v = e.destination;
					
					if ((distance[u] + e.weight) < distance[v]) {
						// relaxation
						distance[v] = distance[u] + e.weight;
						pq.add(new Pair(v, distance[v]));
					}
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			System.out.print(distance[i] + " ");
		}
		System.out.println();
	}
	
	private static void createWeightedGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));
		
		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));
		
		graph[2].add(new Edge(2, 4, 3));
		
		graph[3].add(new Edge(3, 5, 1));
		
		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
	}
	
	public static void main(String[] args) {
		int V = 6;
		int source = 0;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createWeightedGraph(graph);
		dijkstra(graph, source, V);
	}
}