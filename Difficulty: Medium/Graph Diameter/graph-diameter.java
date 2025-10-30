class Solution {
    int gMax;
    public int diameter(int V, int[][] edges) {
        // Code here
        boolean[] vis = new boolean[V]; int n = edges.length;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[V];
        
        for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int src = edges[i][0]; int dest = edges[i][1];
            
            graph[src].add(dest); graph[dest].add(src);
        }
        gMax = 0;
        
        dfs(graph,vis,0);
        
        return (gMax-1);
    }
    public int dfs(ArrayList<Integer>[] graph, boolean[] vis, int st){
        int max1 = 0; int max2 = 0;
        vis[st] = true;
        
        for(int neigh : graph[st]){
            if(!vis[neigh]){
                int count = dfs(graph,vis,neigh);
                if(count > max1){
                    max2 = Math.max(max1,max2);
                    max1 = count;
                }else if(count > max2){
                    max2 = count;
                }
            }
        }
        
        gMax = Math.max(gMax,(max1+max2)+1);
        return max1+1;
    }
}