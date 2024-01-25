//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private void dfs(int s, ArrayList<Integer>[] adj1, boolean[] vis) {
        vis[s] = true;
        for (int x : adj1[s]) {
            if (!vis[x]) {
                dfs(x, adj1, vis);
            }
        }
    }

    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // checked: number of vertices should be equal to (number of nodes -1) V=(N-1)
        // There should not be any disconnected node
        if ((n - m) != 1) {
            return false;
        }

        boolean[] vis = new boolean[n];
        ArrayList<Integer>[] adj1 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj1[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> edge : edges) {
            adj1[edge.get(0)].add(edge.get(1));
            adj1[edge.get(1)].add(edge.get(0));
        }

        dfs(0, adj1, vis);

        for (boolean x : vis) {
            if (!x) {
                return false;
            }
        }

        return true;
    }
}

