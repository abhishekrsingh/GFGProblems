

class Solution {

    public int minCost(int[][] houses) {
        int n = houses.length;
        boolean[] vis = new boolean[n];
        int[] minDist = new int[n];
        
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            
            // pick unvisited node with minimum connection cost
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }
            
            vis[u] = true;
            ans += minDist[u];
            
            // update distances of remaining nodes
            for (int v = 0; v < n; v++) {
                if (!vis[v]) {
                    int cost = Math.abs(houses[u][0] - houses[v][0]) 
                             + Math.abs(houses[u][1] - houses[v][1]);
                    minDist[v] = Math.min(minDist[v], cost);
                }
            }
        }
        
        return ans;
    }
}
