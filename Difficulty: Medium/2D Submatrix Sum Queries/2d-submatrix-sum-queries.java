class Solution {
    public int solve(int[][] preSum, int r1, int c1, int r2, int c2){
        // Start with full rectangle sum from (0,0) to (r2,c2)
        int ans = preSum[r2][c2];

        // Remove the area above r1
        if (r1 > 0) {
            ans -= preSum[r1 - 1][c2];
        }

        // Remove the area left of c1
        if (c1 > 0) {
            ans -= preSum[r2][c1 - 1];
        }

        // Add back the overlapped top-left area
        // because it got subtracted twice
        if (r1 > 0 && c1 > 0) {
            ans += preSum[r1 - 1][c1 - 1];
        }
        
        return ans;
    }
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int m = queries.length;
        ArrayList<Integer> result = new ArrayList<>();
        // prefix sum
        int[][] preSum = new int[mat.length][mat[0].length];
        // Initialize first cell
        preSum[0][0] = mat[0][0];

        // Build prefix sum for first row
        // Each cell stores sum of elements to its left
        for (int j = 1; j < mat[0].length; j++) {
            preSum[0][j] = preSum[0][j - 1] + mat[0][j];
        }

        // Build prefix sum for first column
        // Each cell stores sum of elements above it
        for (int i = 1; i < mat.length; i++) {
            preSum[i][0] = preSum[i - 1][0] + mat[i][0];
        }

        // Build prefix sum for remaining cells
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                // Formula:
                // current cell
                // + sum from top
                // + sum from left
                // - overlapping top-left area
                preSum[i][j] = mat[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        
        for(int i=0; i<m; i++){
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            int ans = solve(preSum, r1, c1, r2, c2);
            result.add(ans);
        }
        return result;
    }
}
