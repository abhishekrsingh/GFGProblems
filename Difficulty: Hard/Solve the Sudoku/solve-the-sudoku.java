//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    public static void solveSudoku(int[][] mat) {
        solve(mat);
    }

    public static boolean solve(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] == 0) {  // Empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(mat, i, j, num)) {
                            mat[i][j] = num;

                            if (solve(mat)) {
                                return true;
                            } else {
                                mat[i][j] = 0;  // Backtrack
                            }
                        }
                    }
                    return false;  // No valid number found, need to backtrack
                }
            }
        }
        return true;  // Sudoku is solved
    }

    public static boolean isValid(int[][] mat, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num) return false;  // Check row
            if (mat[i][col] == num) return false;  // Check column
            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;  // Check subgrid
        }
        return true;
    }
}