//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int shortestPath(ArrayList<ArrayList<int []>>adj,int V, int src, int dest){
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[src]=0;
        pq.add(new int[]{0,src});
        while(!pq.isEmpty()){
            int [] curr=pq.poll();
            int w=curr[0];
            int u=curr[1];
            if(w>dist[u]){
                continue;
            }
            for(int neighbour[] :adj.get(u)){
                int v=neighbour[0];
                int d=neighbour[1];
                if(u==src &&v==dest || u==dest && v==src ){
                    continue;
                }
                if(dist[v]>d+w){
                    dist[v]=d+w;
                    pq.add(new int[]{d+w,v});
                }
            }
        }
        return dist[dest];
    }
    public int findMinCycle(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int []>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        int minCycle=Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            int d=edges[i][2];
            
            int dist=shortestPath(adj,V,src,dest );
            if(dist!=Integer.MAX_VALUE){
                // mean source or destiation ke bich me bhe ak edge hai wo wo cyclic kr rha hia graph ko
                minCycle=Math.min(minCycle,dist+d);
            }
            
        }
        return minCycle;
        
    }
};