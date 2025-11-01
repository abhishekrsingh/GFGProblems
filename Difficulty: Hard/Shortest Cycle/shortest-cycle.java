class Solution {
    public int shortCycle(int V, int[][] edges) {
        
        // Represent edge -> graph
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int shortest = Integer.MAX_VALUE; // ans
        for(int start=0; start<V; start++){
            int[] parent = new int[V]; // will store the parent for each nodes
            Arrays.fill(parent, -1); // initially
            int[] level = new int[V]; // will store the dist from parent node
            Arrays.fill(level, -1); // initially to mark as un-visited

            Queue<Integer> q = new LinkedList<>(); // for bfs
            q.offer(start); // start from this node
            level[start] = 0; // starting dist

            //BFS

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int neighbour : graph[curr]){
                    if(level[neighbour]==-1){ // matlb abhi visited nahi h
                        level[neighbour] = level[curr] + 1; // increase dist
                        parent[neighbour] = curr; // assign parent
                        q.offer(neighbour); // add it to q for next processing
                    }else if(neighbour != parent[curr]){ // visited hai aur parent bhi nahi h, matlb back edge h (kisi ne visit kiya h pkka cycle h)
                    int currCycle = level[neighbour] + level[curr] + 1; // curr tak ka dist + curr se neighbour tak ka dist + 1 (for parent)
                        shortest = Math.min(shortest, currCycle); // update shortest
                    }
                }
            }
        }
        return shortest==Integer.MAX_VALUE? -1 : shortest;
    }
}