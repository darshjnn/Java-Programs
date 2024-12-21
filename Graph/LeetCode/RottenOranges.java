/*
994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten,
because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


*/

package Graph.LeetCode;

import java.util.*;

public class RottenOranges {
	public static int rottenOranges(int[][] grid) {
		int col = grid[0].length;
		int row = grid.length;
		int freshOranges = 0;
		int minutes = -1;
		Queue<int[]> q = new LinkedList<>();
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

//		Count Fresh Oranges & push Rotten Oranges to Queue
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					++freshOranges;
				} else if (grid[i][j] == 2) {
					q.offer(new int[]{i, j});
				}
			}
		}
		
		if (freshOranges == 0) {
			return 0;
		}
		
		if (q.isEmpty()) {
			return -1;
		}

//		Count Minutes
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cell = q.poll();
				for (int[] dir : dirs) {
					assert cell != null;
					int y = cell[0] + dir[0];
					int x = cell[1] + dir[1];
					if (x >= 0 && x < col && y >= 0 && y < row && grid[x][y] == 1) {
						--freshOranges;
						grid[x][y] = 2;
						q.offer(new int[]{x, y});
					}
				}
			}
			++minutes;
		}
		
		if (freshOranges == 0) {
			return minutes;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
		System.out.println(rottenOranges(grid));
	}
}