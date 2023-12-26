//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int mat[][], int n)
    {
        // code here 
        if(n==1) return mat[0][0];
        if(n==2) return mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
        
        int det = 0;
        
        for(int i=0; i<n; i++){
            int cof = (int)Math.pow(-1,i)*mat[0][i]*determinantOfMatrix(sub(mat,0,i),n-1);
            det = det + cof;
        }
        return det;
    }
    
    static int[][] sub(int[][] mat, int r, int c){
        int n = mat.length;
        int arr[][] = new int[n-1][n-1];
        
        int row=0, col =0;
        for(int i=0; i<n; i++){
            if(i!=r){
                for(int j=0; j<n; j++){
                    if(j!=c){
                        arr[row][col] = mat[i][j];
                        col++;
                    }
                }
                col = 0;
                row++;
            }
        }
        return arr;
    }
}

