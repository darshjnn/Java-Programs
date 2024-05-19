/*
Strongly Connected Component: in which every vertex of the component can be reached from every other
vertex of that component

To find the Strongly Connected Components in the graph.
It is only for Directed Graph.
It follows 3 steps:
	1. Get nodes in the Stack (Topological Sort). {Time Complexity: O(V + E)}
	2. Transpose the Graph. {Time Complexity: O(V + E)}
	3. Perform DFS. {Time Complexity: O(V + E)}
Time Complexity of Kosaraju's Algorithm comes out to be  O(V + E).
 */

package Graph;

import java.util.*;

public class KosarajuAlgorithm {
	static class Edge {
		int source;
		int destination;
		
		Edge(int src, int dest) {
			this.source = src;
			this.destination = dest;
		}
	}
	
	private static void createGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 4));
	}
	
	private static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
		vis[curr] = true;
		
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if (!vis[e.destination]) {
				topSort(graph, e.destination, vis, s);
			}
		}
		s.push(curr);
	}
	
	private static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
		vis[curr] = true;
		System.out.print(curr + " ");
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if (!vis[e.destination]) {
				dfs(graph, e.destination, vis);
			}
		}
	}
	
	private static void kosaraju(ArrayList<Edge>[] graph, int V) {
		Stack<Integer> s = new Stack<>();
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				topSort(graph, i, vis, s);
			}
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] transpose = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			vis[i] = false;
			transpose[i] = new ArrayList<>();
		}
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < graph[i].size(); j++) {
				Edge e = graph[i].get(j);
				transpose[e.destination].add(new Edge(e.destination, e.source));
			}
		}
		
		while (!s.isEmpty()) {
			int curr = s.pop();
			if (!vis[curr]) {
				dfs(transpose, curr, vis);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		int V = 5;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		
		createGraph(graph);
		kosaraju(graph, V);
	}
}