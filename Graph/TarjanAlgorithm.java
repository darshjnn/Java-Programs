/*
Bridge in a Graph: It is an edge, whose deletion increases number of Graph's number of connected
				   components. It is generally used in Undirected Graphs.
				   
Articulation Point or Cut Vertex: A vertex in an Undirected Graph is an Articulation point (or cut vertex)
								  if removing it (and edges through it) disconnects the Graph.

Tarjan's Algorithm can be used for:
	1. Topological sort
	2. To find Bridge in graph
	3. To find Articulation Point [Time Complexity: O(V+E)]
	4. To find Strongly connected components

Ancestor: A node A that was discovered before current node in DFS.

A node may or maybe Articulation point, if it falls under following two cases:
Case 1: parent == -1, i.e. DFS starts with this node, then, this node must have more than 1 child nodes &
		they must be disconnected from each other, i.e., no direct or indirect Edge must be there.
	
Case 2: parent != -1, two subcases arises for this condition:
			Subcase 1: the next node is not visited, then, for Articulation point, there must not be any
					   Back-edge for the child node.
			Subcase 2: The current node is the root of a cycle.
*/

package Graph;

import java.util.*;

public class TarjanAlgorithm {
	static class Edge {
		int s;
		int d;
		
		Edge(int source, int destination) {
			this.s = source;
			this.d = destination;
		}
	}
	
	private static void createGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
	}
	
	@SuppressWarnings("UnnecessaryContinue")
	private static void dfsBridge(ArrayList<Edge>[] graph, int curr, boolean[] vis, int[] dt, int[] low, int time, int parent) {
		vis[curr] = true;
		dt[curr] = low[curr] = ++time;
		
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if (e.d == parent) {
				continue;
			} else if (!vis[e.d]) {
				dfsBridge(graph, e.d, vis, dt, low, time, curr);
				low[curr] = Math.min(low[curr], low[e.d]);
				if (dt[curr] < low[e.d]) {
					System.out.println("Bridge found from: " + curr + " --- " + e.d);
				}
			} else {
				low[curr] = Math.min(low[curr], dt[e.d]);
			}
		}
	}
	
	private static void getBridge(ArrayList<Edge>[] graph, int V) {
		int[] dt = new int[V];  // Discovery Time
		int[] low = new int[V]; // Lowest Discovery Time
		int time = 0;
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfsBridge(graph, i, vis, dt, low, time, -1);
			}
		}
	}
	
	@SuppressWarnings("UnnecessaryContinue")
	private static void dfsAP(ArrayList<Edge>[] graph, int curr, boolean[] vis, int[] dt, int[] low, int time, int parent, boolean[] AP) {
		vis[curr] = true;
		dt[curr] = low[curr] = ++time;
		int children = 0;
		
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			int neighbour = e.d;
			
			if (neighbour == parent) {
				continue;
			} else if (vis[neighbour]) {
				low[curr] = Math.min(low[curr], dt[neighbour]);
			} else {
				dfsAP(graph, neighbour, vis, dt, low, time, curr, AP);
				low[curr] = Math.min(low[curr], low[neighbour]);
				if (dt[curr] <= low[neighbour] && parent != -1) {
					AP[curr] = true;
				}
				children++;
			}
		}
		
		if (parent == -1 && children > 1) {
			AP[curr] = true;
		}
	}
	
	private static void getAP(ArrayList<Edge>[] graph, int V) {
		int[] dt = new int[V];
		int[] low = new int[V];
		int time = 0;
		boolean[] vis = new boolean[V];
		boolean[] AP = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfsAP(graph, i, vis, dt, low, time, -1, AP);
			}
		}
		
		for (int i = 0; i < V; i++) {
			if (AP[i]) {
				System.out.println("AP found: " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		int V = 6;
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		
		createGraph(graph, V);
		getBridge(graph, V);
		getAP(graph, V);
	}
}