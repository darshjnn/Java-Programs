/*
Prim Algorithm

A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a
connected, edge-weighted undirected graph that connects all the vertices together, without any
cycles and with the minimum possible total edge weight.

Time Complexity: E(logE)

*/

package Graph;

import java.util.*;

import java.util.ArrayList;

public class PrimAlgorithm {
	public static void createGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 2, 15));
		graph[0].add(new Edge(0, 3, 30));
		
		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 40));
		
		graph[2].add(new Edge(2, 0, 15));
		graph[2].add(new Edge(2, 3, 50));
		
		graph[3].add(new Edge(3, 1, 40));
		graph[3].add(new Edge(3, 2, 50));
	}
	
	public static void primAlgo(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		ArrayList<Edge> mst = new ArrayList<>();
		int mstCost = 0;
		
		pq.offer(new Pair(0, 0, 0));
		while (!pq.isEmpty()) {
			Pair curr = pq.poll();
			if (!vis[curr.dest]) {
				vis[curr.dest] = true;
				
				mstCost += curr.wt;
				mst.add(new Edge(curr.src, curr.dest, curr.wt));
				
				for (Edge e : graph[curr.src]) {
					if (!vis[e.dest]) {
						pq.offer(new Pair(e.src, e.dest, e.wt));
					}
				}
			}
		}
		
		System.out.println("Minimum Spanning Tree:");
		System.out.println("Source Destination Weight");
		for (Edge e : mst) {
			System.out.println("\t" + e.src + "\t\t" + e.dest + "\t\t" + e.wt);
		}
		System.out.println("Minimum cost: " + mstCost);
	}
	
	public static void main(String[] args) {
		int V = 4;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph, V);
		
		primAlgo(graph, V);
	}
	
	public static class Pair implements Comparable<Pair> {
		int src, dest, wt;
		
		public Pair(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		
		public int compareTo(Pair p) {
			return this.wt - p.wt;  // For ascending sorting
		}
	}
}