//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean isSafe(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        // r is in range, c is in range, value
        // is L and not yet visited
        return (r >= 0) && (r < row) && (c >= 0) && (c < col) && grid[r][c] == 'L';
    }

    public void dfs(char[][] grid, int r, int c) {

        // These arrays are used to get
        // r and c numbers of 8
        // neighbours of a given cell
        int[] rNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNbr = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        grid[r][c] = 'W';

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) {
            int newR = r + rNbr[k];
            int newC = c + cNbr[k];
            if (isSafe(grid, newR, newC)) {
                dfs(grid, newR, newC);
            }
        }
    }

    // Function to find the number of islands.
    public int countIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // Initialize count as 0 and traverse through
        // all cells of the given matrix
        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {

                // If a cell with value L is found,
                // then a new island is found
                if (grid[r][c] == 'L') {

                    // Visit all cells in this island.
                    dfs(grid, r, c);

                    // increment the island count
                    ++count;
                }
            }
        }
        return count;
    }
}