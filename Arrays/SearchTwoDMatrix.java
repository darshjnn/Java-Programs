/*
74. Search a 2D Matrix

You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

*/

package LeetCode;

public class SearchTwoDMatrix {
    public static int getColUtil(int[][] matrix, int target, int low, int high) {
        int m = matrix[0].length;
        int mid = low + (high - low) / 2;
        if (low > high) {
            return 0;
        }
        if (matrix[mid][m - 1] == target) {
            return mid;
        } else if (matrix[mid][m - 1] > target) {
            if (matrix[mid][0] <= target) {
                return mid;
            }
            return getColUtil(matrix, target, low, mid - 1);
        } else {
            if (matrix[mid][0] >= target) {
                return mid;
            }
            return getColUtil(matrix, target, mid + 1, high);
        }
    }

    public static boolean binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) {
            return true;
        } else if (arr[mid] > key) {
            return binarySearch(arr, key, low, mid - 1);
        }
        return binarySearch(arr, key, mid + 1, high);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        int col = getColUtil(matrix, target, 0, n);
        System.out.println(col);
        if (matrix[col][m] < target) {
            return false;
        }
        return binarySearch(matrix[col], target, 0, m);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        // int[][] matrix = { { 1 } };
        int target = 10;
        System.out.println(searchMatrix(matrix, target));
    }
}

/*
Alternate Solution: 
public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            int rowIdx = mid / n;
            int colIdx = mid % n;
            if(matrix[rowIdx][colIdx] == target) return true;
            else if(target > matrix[rowIdx][colIdx]) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
*/