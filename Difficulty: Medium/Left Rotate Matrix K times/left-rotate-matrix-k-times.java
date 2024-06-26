//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    void swap( int[] arr , int i , int j )
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void reverse( int[] arr , int s,int e)
    {
        while( s < e)
         swap(arr,s++,e--);
    }
    void rotateArrayByRight(int[] arr , int k)
    {
        //reverse whole array
        reverse( arr , 0 , arr.length-1);
        
        //reverse from 0 to n -k-1
        reverse( arr , 0 , (arr.length-k)-1);
        
        //reverse from n-k to n-1
        reverse( arr , arr.length-k,arr.length-1);
        
    }
    int[][] rotateMatrix(int k, int mat[][]) {
        
        k = k%mat[0].length;
        
        //if k is 0 then no rotation is needed
        if( k == 0 )
          return mat;
          
        for( int i = 0; i < mat.length; i++)
          rotateArrayByRight( mat[i],k);
        
        return mat;
        
    }
}