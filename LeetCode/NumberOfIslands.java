/*
200. Number Of Islands

Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally
or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
Output: 3

*/

package LeetCode;

public class NumberOfIslands {
    public static int island(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        if (n == 0) {
            return 0;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    findIsland(grid, visited, i, j, m, n);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public static void findIsland(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        int[][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1' && !visited[x][y]) {
                visited[x][y] = true;
                findIsland(grid, visited, x, y, m, n);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','0','0'},
            {'1','1','1','0','0'},
            {'1','1','1','0','0'},
            {'1','0','1','1','1'},
        };

        System.out.println(island(grid));
    }
}

/*
Alternate Solution

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

        public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r + 1, c);    // down
        dfs(grid, r - 1, c);    // up
        dfs(grid, r, c + 1);    // right
        dfs(grid, r, c - 1);    // left
    }
}

*/