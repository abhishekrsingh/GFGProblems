//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] arr) {
        
        int n = arr.length;
        int[] res = new int[n * n];
        int p = 0;
    
        int i = 0, j = 0;
    
        while (i < n && j < n) {
            // Traverse diagonally up
            while (i >= 0 && j < n) {
                res[p++] = arr[i--][j++];
            }
            
            // Adjust i and j for next iteration
            if (i < 0 && j < n) {
                i = 0;
            } else if (j == n) {
                i += 2;
                j--;
            }
            
            // Traverse diagonally down
            while (i < n && j >= 0) {
                res[p++] = arr[i++][j--];
            }
            
            // Adjust i and j for next iteration
            if (j < 0 && i < n) {
                j = 0;
            } else if (i == n) {
                j += 2;
                i--;
            }
        }
    
        return res;

    }
}