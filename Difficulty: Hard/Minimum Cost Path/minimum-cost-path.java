//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    static class Cell implements Comparable<Cell> {
        int x, y, cost;

        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        // Compare cells based on their cost
        public int compareTo(Cell other) {
            return this.cost - other.cost;
        }
    }
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;

        // Directions array for moving in the grid (left, right, up, down)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 2D array to store the minimum cost to reach each cell
        int[][] minCost = new int[n][n];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority queue to select the cell with the minimum cost
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(0, 0, grid[0][0]));
        minCost[0][0] = grid[0][0];

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Cell current = pq.poll();

            // If we've reached the bottom-right cell, return the cost
            if (current.x == n - 1 && current.y == n - 1) {
                return current.cost;
            }

            // Explore the four possible directions
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = current.cost + grid[newX][newY];

                    // If a lower cost path is found, update and add to the queue
                    if (newCost < minCost[newX][newY]) {
                        minCost[newX][newY] = newCost;
                        pq.add(new Cell(newX, newY, newCost));
                    }
                }
            }
        }

        // If we reach here, there's an error, return -1 (though this should never happen)
        return -1;
    }
}