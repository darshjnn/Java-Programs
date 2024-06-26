package LeetCode;

import java.util.ArrayList;

public class NQueensProblem {
	private static boolean isSafe(int row, int col, char[][] board) {
		// horizontal
		for (int j = 0; j < board.length; j++) {
			if (board[row][j] == 'Q') {
				return false;
			}
		}
		
		// vertical
		for (char[] chars : board) {
			if (chars[col] == 'Q') {
				return false;
			}
		}
		
		// upper left
		int r = row;
		for (int c = col; c >= 0 && r >= 0; c--, r--) {
			if (board[r][c] == 'Q') {
				return false;
			}
		}
		
		// upper right
		r = row;
		for (int c = col; c < board.length && r >= 0; r--, c++) {
			if (board[r][c] == 'Q') {
				return false;
			}
		}
		
		// lower left
		r = row;
		for (int c = col; c >= 0 && r < board.length; r++, c--) {
			if (board[r][c] == 'Q') {
				return false;
			}
		}
		
		// lower right
		for (int c = col; c < board.length && r < board.length; c++, r++) {
			if (board[r][c] == 'Q') {
				return false;
			}
		}
		
		return true;
	}
	
	private static void saveBoard(char[][] board, ArrayList<ArrayList<String>> allBoards) {
		StringBuilder row;
		ArrayList<String> newBoard = new ArrayList<>();
		
		for (char[] chars : board) {
			row = new StringBuilder();
			for (int j = 0; j < board[0].length; j++) {
				if (chars[j] == 'Q')
					row.append('Q');
				else
					row.append('.');
			}
			newBoard.add(row.toString());
		}
		
		allBoards.add(newBoard);
	}
	
	private static void helper(char[][] board, ArrayList<ArrayList<String>> allBoards, int col) {
		if (col == board.length) {
			saveBoard(board, allBoards);
			return;
		}
		
		for (int row = 0; row < board.length; row++) {
			if (isSafe(row, col, board)) {
				board[row][col] = 'Q';
				helper(board, allBoards, col + 1);
				board[row][col] = '.';
			}
		}
	}
	
	private static ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> allBoards = new ArrayList<>();
		char[][] board = new char[n][n];
		
		helper(board, allBoards, 0);
		return allBoards;
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solveNQueens(n));
	}
}