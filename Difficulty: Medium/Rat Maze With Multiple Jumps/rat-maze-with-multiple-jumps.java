class Solution {
    boolean solve(int r, int c, int[][] mat, int[][] path, int[][] dead, int n) {

        // Check for invalid coordinates
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;

        // Destination reached
        if (r == n - 1 && c == n - 1) {
            path[r][c] = 1;
            return true;
        }

        // Blocked cell
        if (mat[r][c] == 0)
            return false;

        // Already explored and known to be a dead end
        if (dead[r][c] == 1)
            return false;

        // Mark current cell as part of the path
        path[r][c] = 1;

        int jump = mat[r][c];

        // Try all jump lengths from 1 to mat[r][c]
        for (int k = 1; k <= jump; k++) {

            // Move right first (problem requirement)
            if (c + k < n) {
                if (solve(r, c + k, mat, path, dead, n))
                    return true;
            }

            // Then move down
            if (r + k < n) {
                if (solve(r + k, c, mat, path, dead, n))
                    return true;
            }
        }

        // Backtrack: remove current cell from path
        path[r][c] = 0;

        // Mark this cell as a dead state
        dead[r][c] = 1;

        return false;
    }

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {

        int n = mat.length;

        // Stores the final path
        int[][] path = new int[n][n];

        // Dead-state memoization table
        int[][] dead = new int[n][n];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Check if a valid path exists
        if (solve(0, 0, mat, path, dead, n)) {

            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    row.add(path[i][j]);
                }

                ans.add(row);
            }

            return ans;
        }

        // No valid path found
        ArrayList<Integer> row = new ArrayList<>();
        row.add(-1);
        ans.add(row);

        return ans;
    }
}