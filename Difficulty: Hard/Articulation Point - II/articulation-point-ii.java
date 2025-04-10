//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int time = 0;
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V]; // To store articulation points

        // Initialize arrays
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
            visited[i] = false;
            disc[i] = -1;
            low[i] = -1;
        }

        // Call DFS for all unvisited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, disc, low, parent, ap);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) result.add(i);
        }

        if (result.size() == 0) result.add(-1);
        return result;
    }

    static void dfs(int u, ArrayList<ArrayList<Integer>> graph, boolean[] visited,
                    int[] disc, int[] low, int[] parent, boolean[] ap) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, graph, visited, disc, low, parent, ap);
                
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1) ap[u] = true; 
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true; 
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]); 
            }
        }
    }
}