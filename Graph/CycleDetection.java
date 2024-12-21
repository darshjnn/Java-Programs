/*
For Cycle Detection in Undirected Graph, following can be used:
	1. DFS
	2. BFS
	3. DSU (Disjoint Set Union)

For Cycle Detection in Directed Graph, following can be used:
	1. DFS
	2. BFS
	3. Topological Sort (Kahn's Algorithm)
*/

package Graph;

import java.util.*;

public class CycleDetection {
	// Create Directed Graph
	public static void createGraphDirected(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 0));
		
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 0));
	}
	
	// Detect Cycle in Undirected Graph using DFS
	public static boolean isCycleUndDFSUtil(ArrayList<Edge>[] graph, boolean[] vis,
	                                        int curr, int par) {
		vis[curr] = true;
		for (Edge e : graph[curr]) {
			if (!vis[e.dest]) {
				return isCycleUndDFSUtil(graph, vis, e.dest, curr);
			} else if (vis[e.dest] && e.dest != par) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isCycleUndDFS(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (isCycleUndDFSUtil(graph, vis, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Detect Cycle in Undirected Graph using BFS
	public static boolean isCycleUndBFSUtil(ArrayList<Edge>[] graph, boolean[] vis,
	                                        int src) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (vis[curr]) {
				return true;
			}
			vis[curr] = true;
			for (Edge e : graph[curr]) {
				q.offer(e.dest);
			}
		}
		return false;
	}
	
	public static boolean isCycleUndBFS(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				return isCycleUndBFSUtil(graph, vis, i);
			}
		}
		return false;
	}
	
	// Detect Cycle in Directed Graph using DFS
	public static boolean isCycleDirDFSUtil(ArrayList<Edge>[] graph, boolean[] stack,
	                                         boolean[] vis, int curr) {
		vis[curr] = true;
		stack[curr] = true;
		for (Edge e : graph[curr]) {
			if (stack[e.dest]) {
				return true;
			}
			if (!vis[e.dest] && isCycleDirDFSUtil(graph, stack, vis, e.dest)) {
				return true;
			}
		}
		stack[curr] = false;
		return false;
	}
	
	public static boolean isCycleDirectedDFS(ArrayList<Edge>[] graph, int V) {
		boolean[] stack = new boolean[V];
		boolean[] vis = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				return isCycleDirDFSUtil(graph, stack, vis, i);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		// Cycle Detection for Undirected graph
		/*
		 *   1 --- 3
		 *  /      | \
		 * 0       |  5 --- 6
		 *  \      | /
		 *   2 --- 4
		 */
		
		int V = 7;
		
		// Create Undirected Graph
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		Graphs.createGraph(graph, V);
		
		System.out.print("Cycle Detection for Undirected graph using DFS: ");
		System.out.println(isCycleUndDFS(graph, V) + "\n");
		
		System.out.print("Cycle Detection for Undirected graph using BFS: ");
		System.out.println(isCycleUndBFS(graph, V) + "\n");
		
		
		// Create Directed Graph
		V = 4;
		@SuppressWarnings("unchecked")
		ArrayList<Graph.Edge>[] graphDirected = new ArrayList[V];
		createGraphDirected(graphDirected, V);
		System.out.println("Detect Cycle in Directed Graph using DFS: " +
				isCycleDirectedDFS(graphDirected, V));
	}
}