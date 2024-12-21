/*

We have a matrix where each cell contains either a ‘0’ or a ‘1’, and any cell containing a 1
is called a filled cell.
Two cells are said to be connected if they are adjacent to each other horizontally, vertically,
or diagonally.
If one or more filled cells are also connected, they form a region.

Find the size of the largest region.

Example:
Input: M[][] = { {0, 0, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1} }
Output: 4

*/

package Graph.Assignment;

public class LargestRegion {
	public static int largestRegion(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int maxArea = 0;
		boolean[][] vis = new boolean[rows][cols];
		int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!vis[i][j] && grid[i][j] == 1) {
					int area = 1;
					vis[i][j] = true;
					for (int[] dir : dirs) {
						int x = i + dir[0];
						int y = j + dir[1];
						if (x >= 0 && x < rows && y >= 0 && y < cols &&
								!vis[x][y] && grid[x][y] == 1) {
							++area;
							vis[x][y] = true;
						}
					}
					maxArea = Math.max(area, maxArea);
				}
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0, 0, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
		System.out.println(largestRegion(grid));
	}
}