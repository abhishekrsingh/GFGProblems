//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length; // length includes one extra for the dimensions
        
        // Create a 2D array to store the minimum multiplication costs
        int[][] dp = new int[n][n];

        // Initialize the primary diagonal as 0 because a single matrix doesn't require multiplication
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is chain length.
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    // q = cost/scalar multiplications
                    int q = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }

        // Return the minimum cost from the start to the end of the matrix chain
        return dp[1][n - 1];
    }
}