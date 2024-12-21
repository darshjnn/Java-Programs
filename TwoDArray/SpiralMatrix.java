/*
54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/

package TwoDArray;

public class SpiralMatrix {
	public static void spiralOrder(int[][] matrix) {
		int startRow = 0;
		int startCol = 0;
		int endRow = matrix.length - 1;
		int endCol = matrix[0].length - 1;
		while (startRow <= endRow && startCol <= endCol) {
			// Top
			for (int j = startCol; j <= endCol; j++) {
				System.out.print(matrix[startRow][j] + " ");
			}
			// Right
			for (int i = (startRow + 1); i <= endRow; i++) {
				System.out.print(matrix[i][endCol] + " ");
			}
			// Bottom
			for (int j = (endCol - 1); j >= startCol; j--) {
				if (startRow == endRow) {
					break;
				}
				System.out.print(matrix[endRow][j] + " ");
			}
			// Left
			for (int i = (endRow - 1); i >= (startRow + 1); i--) {
				if (startCol == endCol) {
					break;
				}
				System.out.print(matrix[i][startCol] + " ");
			}
			++startRow;
			++startCol;
			--endRow;
			--endCol;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		spiralOrder(matrix);
	}
}