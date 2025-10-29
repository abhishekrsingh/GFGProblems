class Solution {
  public:
    int diameter(int V, vector<vector<int>>& edges) {
        // Step 1: Build adjacency list
        vector<vector<int>> graph(V);
        for (auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].push_back(v);
            graph[v].push_back(u);
        }
        
        // Step 2: First BFS from node 0 to find one end of diameter
        pair<int, int> firstBFS = bfs(0, graph, V);
        int endPoint1 = firstBFS.first;
        
        // Step 3: Second BFS from the found endpoint to get diameter
        pair<int, int> secondBFS = bfs(endPoint1, graph, V);
        int diameter = secondBFS.second;
        
        return diameter;
    }
    
private:
    // BFS function that returns (farthest_node, max_distance)
    pair<int, int> bfs(int start, vector<vector<int>>& graph, int V) {
        vector<int> distance(V, -1);  // -1 means unvisited
        queue<int> q;
        
        // Initialize BFS from start node
        q.push(start);
        distance[start] = 0;
        
        int farthestNode = start;
        int maxDist = 0;
        
        while (!q.empty()) {
            int current = q.front();
            q.pop();
            
            // Explore all neighbors
            for (int neighbor : graph[current]) {
                if (distance[neighbor] == -1) {  // Not visited
                    distance[neighbor] = distance[current] + 1;
                    q.push(neighbor);
                    
                    // Update if we found a farther node
                    if (distance[neighbor] > maxDist) {
                        maxDist = distance[neighbor];
                        farthestNode = neighbor;
                    }
                }
            }
        }
        
        return {farthestNode, maxDist};
    }
};
