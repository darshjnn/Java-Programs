/*
733. Flood Fill

An image is represented by an m x n integer grid image where image[i][j] represents the pixel
value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the
image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally
to the starting pixel of the same color as the starting pixel, plus any pixels connected
4-directionally to those pixels (also with the same color), and so on. Replace the color of
all the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels)
are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to
the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.

*/

package LeetCode;

public class FloodFill {
	public static void helper(int[][] image, int sr, int sc, int color,
	                          boolean[][] vis, int prevColor) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ||
				image[sr][sc] != prevColor || vis[sr][sc]) {
			return;
		}
		vis[sr][sc] = true;
		image[sr][sc] = color;
		helper(image, (sr + 1), sc, color, vis, prevColor);
		helper(image, (sr - 1), sc, color, vis, prevColor);
		helper(image, sr, (sc + 1), color, vis, prevColor);
		helper(image, sr, (sc - 1), color, vis, prevColor);
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		boolean[][] vis = new boolean[image.length][image[0].length];
		helper(image, sr, sc, color, vis, image[sr][sc]);
		return image;
	}
	
	public static void main(String[] args) {
		int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		int[][] newImg = floodFill(image, 1, 1, 2);
		for (int[] c : newImg) {
			for (int r : c) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}