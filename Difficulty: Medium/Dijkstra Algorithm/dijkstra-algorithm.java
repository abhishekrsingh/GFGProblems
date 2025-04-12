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

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<DijkstraPair>> adjList = new ArrayList<>();
        int[] distance = new int[V];
        for(int i=0; i<V; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(new DijkstraPair(edge[1], edge[2]));
            adjList.get(edge[1]).add(new DijkstraPair(edge[0], edge[2]));
        }
        TreeSet<DijkstraPair> queue = new TreeSet<>((a, b) -> {
            if(a.node == b.node) return a.weight - b.weight;
            return a.node - b.node;
        });
        queue.add(new DijkstraPair(src, 0));
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;
        while (!queue.isEmpty()) {
            DijkstraPair dijkstraPair = queue.pollFirst();
            int node = dijkstraPair.node;
            int wt = dijkstraPair.weight;
            for (DijkstraPair neighbour : adjList.get(node)) {
                int newWeight = wt + neighbour.weight;
                if(distance[neighbour.node] > newWeight) {
                    distance[neighbour.node] = newWeight;
                    queue.add(new DijkstraPair(neighbour.node, newWeight));
                }
            }
        }
        return distance;
        
    }
}

class DijkstraPair {
    int node, weight;
    public DijkstraPair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}