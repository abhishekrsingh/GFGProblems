class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        
        //If there's only one v (0), that's our answer!
        if(V == 1)
            return new ArrayList<>(Collections.singletonList(0));
            
        //Let's make an adjacency list out of the edges!
        ArrayList<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) 
            adj.add(new HashSet<>());
        for(int e[] : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        //What are the initial leaves?
        //Those nodes with degree = 1.
        ArrayList<Integer> leaves = new ArrayList<>();
        for(int i = 0;i < V;i++)
            if(adj.get(i).size() == 1)
                leaves.add(i);
                
        //Let's trim the leaves now!
        int remaining = V;
        while(remaining > 2){
            remaining = remaining - leaves.size(); //Non-leaves
            
            //On trimming leaves, we will get new leaves!
            ArrayList<Integer> newLeaves = new ArrayList<>();
            
            for(int leaf : leaves){
                //Get the only predecessor of this leaf
                int neighbor = adj.get(leaf).iterator().next();
                
                //Go there and remove this leaf
                adj.get(neighbor).remove(leaf);
                
                //Now, if this predecessor's degree reduces to 1,
                //it becomes a new leaf
                if(adj.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }
            
            //Now, previous leaves are gone 
            //and new leaves have been produced
            leaves = newLeaves;
        }
        
        return leaves;
    }
}