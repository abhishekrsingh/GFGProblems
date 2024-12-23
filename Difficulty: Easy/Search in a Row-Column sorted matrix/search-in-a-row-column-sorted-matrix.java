//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length, m = mat[0].length;
        int i = 0, j = m - 1;

        while (i < n && j >= 0) {

            // If x > mat[i][j], then x will be greater
            // than all elements to the left of 
            // mat[i][j] in row i, so increment i
            if (x > mat[i][j]) {
                i++;
            }

            // If x < mat[i][j], then x will be smaller
            // than all elements to the bottom of
            // mat[i][j] in column j, so decrement j
            else if (x < mat[i][j]) {
                j--;
            }

            // If x = mat[i][j], return true
            else {
                return true;
            }
        }

        // If x was not found, return false
        return false;
    }
}