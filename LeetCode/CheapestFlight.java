/*
Cheapest Flights within K Stops

There are n cities connected by some number of flights. You are given an array flights where
flights[i] = [from_i, to_i, price_i] indicates that there is a flight from city from_i to city
toi with cost price_i.

You are also given three integers src, dst, and k, return the cheapest price from src to dst
with at most k stops. If there is no such route, return -1.

Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

*/

package LeetCode;

import java.util.*;

public class CheapestFlight {
	
	private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[] prices = new int[n];
		Arrays.fill(prices, Integer.MAX_VALUE);
		prices[src] = 0;
		for (int i = 0; i <= K; i++) {
			int[] temp = prices.clone();
			for (int[] flight : flights) {
				if (prices[flight[0]] == Integer.MAX_VALUE) {
					continue;
				}
				temp[flight[1]] = Math.min(temp[flight[1]], prices[flight[0]] + flight[2]);
			}
			prices = temp.clone();
			
			for (int j = 0; j < n; j++) {
				System.out.print(prices[j] + " ");
			}
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(temp[j] + " ");
			}
			System.out.println();
		}
		return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
	}
	
	public static void main(String[] args) {
		int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
		int n = 4;
		int src = 0;
		int dest = 3;
		int k = 1;
		int cost = findCheapestPrice(n, flights, src, dest, k);
		System.out.println(cost);
	}
}