/*
MST stands for Minimum Spanning Tree here.
Time Complexity: E(logE)
*/

package Graph;

import java.util.*;

public class PrimAlgorithm {
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
	
	private static void createGraph(ArrayList<Edge>[] graph, int[][] arr) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					graph[i].add(new Edge(i, j, arr[i][j]));
				}
			}
		}
		System.out.println();
		System.out.println("Entered Graph is:");
		System.out.println("Source Destination Weight");
		
		for (ArrayList<Edge> edges : graph) {
			for (Edge e : edges) {
				System.out.println("\t" + e.source + "\t\t" + e.destination + "\t\t" + e.weight);
			}
		}
		System.out.println();
	}
	
	public static class Pair implements Comparable<Pair> {
		int source;
		int destination;
		int cost;
		
		public Pair(int source, int destination, int cost) {
			this.source = source;
			this.cost = cost;
			this.destination = destination;
		}
		
		public int compareTo(Pair p2) {
			return this.cost - p2.cost; // Ascending
		}
	}
	
	private static void primsAlgorithm(ArrayList<Edge>[] graph, int V) {
		boolean[] visited = new boolean[V];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		int MSTcost = 0;
		ArrayList<Edge> edge = new ArrayList<>();
		pq.add(new Pair(0, 0, 0));
		while (!pq.isEmpty()) {
			Pair curr = pq.remove();
			if (!visited[curr.destination]) {
				visited[curr.destination] = true;
				MSTcost += curr.cost;
				edge.add(new Edge(curr.source, curr.destination, curr.cost));
				
				for (Edge e : graph[curr.destination]) {
					if (!visited[e.destination]) {
						pq.add(new Pair(e.source, e.destination, e.weight));
					}
				}
			}
		}
		System.out.println("Minimum Spanning Tree:");
		System.out.println("Source Destination Weight");
		for (Edge e : edge) {
			System.out.println("\t" + e.source + "\t\t" + e.destination + "\t\t" + e.weight);
		}
		System.out.println("Minimum cost: " + MSTcost);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices: ");
		int V = sc.nextInt();
		int[][] arr = new int[V][V];
		
		do {
			System.out.println();
			System.out.print("Enter Source: ");
			int source = sc.nextInt();
			System.out.print("Enter Destination: ");
			int destination = sc.nextInt();
			System.out.print("Enter cost: ");
			int cost = sc.nextInt();
			System.out.println();
			if (source < V && destination < V) {
				arr[source][destination] = cost;
			} else {
				System.out.println("Enter valid source or destination...");
			}
			System.out.print("Hit 0 to exit, else enter any number to continue: ");
		} while (sc.nextInt() != 0);
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		
		createGraph(graph, arr);
		primsAlgorithm(graph, V);
		sc.close();
	}
}