class Solution {
    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        // dp[col1][col2] = max chocolates collected at current row
        int[][] dp = new int[m][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Base case: row 0, robots at (0,0) and (0,m-1)
        dp[0][m - 1] = (0 == m - 1) ? grid[0][0] : grid[0][0] + grid[0][m - 1];

        // Process row by row
        for (int row = 1; row < n; row++) {
            int[][] newDp = new int[m][m];
            for (int[] r : newDp) Arrays.fill(r, -1);

            for (int col1 = 0; col1 < m; col1++) {
                for (int col2 = 0; col2 < m; col2++) {
                    if (dp[col1][col2] == -1) continue;

                    // Try all 9 move combinations
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int newCol1 = col1 + d1;
                            int newCol2 = col2 + d2;
                            if (newCol1 < 0 || newCol1 >= m || newCol2 < 0 || newCol2 >= m) continue;
                            
                            int chocolates = (newCol1 == newCol2)
                                    ? grid[row][newCol1]
                                    : grid[row][newCol1] + grid[row][newCol2];

                            newDp[newCol1][newCol2] = Math.max(newDp[newCol1][newCol2],
                                    dp[col1][col2] + chocolates);
                        }
                    }
                }
            }
            dp = newDp; // roll forward
        }

        // Answer = max value in last row
        int result = 0;
        for (int col1 = 0; col1 < m; col1++) {
            for (int col2 = 0; col2 < m; col2++) {
                result = Math.max(result, dp[col1][col2]);
            }
        }
        return result;
    }
}