class Solution {
  public:
    int shortCycle(int V, vector<vector<int>>& edges) {
        // Build adjacency list
        vector<vector<int>> adj(V);
        for (auto& edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        
        int minCycle = INT_MAX;
        
        for (int i = 0; i < V; i++) {
            vector<int> dist(V, -1);
            vector<int> parent(V, -1);
            queue<int> q;
            
            dist[i] = 0;
            q.push(i);
            
            while (!q.empty()) {
                int curr = q.front();
                q.pop();
                
                for (int neighbor : adj[curr]) {
                    if (dist[neighbor] == -1) {
                        // Not visited
                        dist[neighbor] = dist[curr] + 1;
                        parent[neighbor] = curr;
                        q.push(neighbor);
                    } else if (parent[curr] != neighbor) {
                        // Found a cycle
                        minCycle = min(minCycle, dist[curr] + dist[neighbor] + 1);
                    }
                }
            }
        }
        
        return minCycle == INT_MAX ? -1 : minCycle;
    }
};
