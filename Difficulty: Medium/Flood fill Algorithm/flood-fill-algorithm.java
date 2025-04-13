//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        boolean[][] visited = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        solve(image, sr, sc, newColor, oldColor, visited);
        
        return image;
        
    }
    
    public void solve(int[][] image, int sr, int sc, int newColor,
    int oldColor, boolean[][] visited){
        
        for(int i = 0; i<4; i++){
            int x = sr+dx[i];
            int y = sc+dy[i];
            
            if(x >=0 && y>=0 && x<image.length && y<image[0].length && !visited[x][y]
            && image[x][y] == oldColor){
                image[x][y] = newColor;
                visited[x][y] = true;
                solve(image, x, y, newColor, oldColor, visited);
            }
        }
        
    }
}