class Solution {
    public int maxGold(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        // dp table of same dimensions
        int[][] dp = new int[n][m];

        // 1) Initialize last column (no moves possible)
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = mat[i][m - 1];
        }

        // 2) Build table from right to left
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int right   = dp[i][j + 1];                            // move right
                int rightUp = (i > 0     ? dp[i - 1][j + 1] : 0);      // move right-up if in bounds
                int rightDn = (i + 1 < n   ? dp[i + 1][j + 1] : 0);    // move right-down if in bounds
                dp[i][j] = mat[i][j] + Math.max(right, Math.max(rightUp, rightDn));
            }
        }

        // 3) Collect the best starting position in column 0
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i][0]);
        }
        return result;
    }
}