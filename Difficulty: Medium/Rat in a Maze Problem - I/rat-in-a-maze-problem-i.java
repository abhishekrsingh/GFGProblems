//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.length;
        
        boolean visited[][] = new boolean[n][n];
        String path = "";
        
        if(mat[0][0] == 0)return ans;
        solve(0 , 0 , n , mat , visited , path , ans);
        
        return ans;
    }
    
    public boolean Ispossible(int x , int y , int n , boolean[][] visited , int[][] mat){
        if((x >= 0 && x <=n-1) && (y >= 0 && y <= n-1) && visited[x][y] == false && mat[x][y] == 1){
            return true;
        }
        return false;
    }
    
    
    public void solve(int x  , int y , int n , int[][] mat , boolean visited[][] , String path, ArrayList<String> ans){
        
        //base case
        if(x == n-1 && y == n-1){
            ans.add(path);
            return;
        }
        
        //DLRU - 4-movement
        visited[x][y] = true;
        
        //D - DownMovement
        if(Ispossible(x+1 , y , n , visited , mat)){
            solve(x+1 , y , n , mat , visited , path+"D" , ans);
        }
        
        
        //R - RightMovement
        if(Ispossible(x , y+1 , n , visited , mat)){
            solve(x , y+1 , n , mat , visited , path+"R" , ans);
        }
        
        
        //L - LeftMovement
        if(Ispossible(x , y-1 , n , visited , mat)){
            solve(x , y-1 , n , mat , visited , path+"L" , ans);
        }
        
        
        
        //U - UpMovement
        if(Ispossible(x-1 , y , n , visited , mat)){
            solve(x-1 , y , n , mat , visited , path+"U" , ans);
        }
        
        visited[x][y] = false;
        
    }
}