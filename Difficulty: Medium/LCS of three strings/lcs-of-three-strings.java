class Solution {
    static int solve(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        // Base case: If any string length is zero, LCS is 0
        if (i == 0 || j == 0 || k == 0) {
            return 0;
        }

        // If already computed, return from dp table
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        // If last characters of all three strings match
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
            // Include this character in LCS and move one step back in all strings
            return dp[i][j][k] = 1 + solve(s1, s2, s3, i - 1, j - 1, k - 1, dp);
        }

        // If last characters don't match, explore all 3 options:
        // 1. Exclude last char of s1
        // 2. Exclude last char of s2
        // 3. Exclude last char of s3
        // Take maximum of all
        return dp[i][j][k] = Math.max(
                   Math.max(solve(s1, s2, s3, i - 1, j, k, dp),
                            solve(s1, s2, s3, i, j - 1, k, dp)),
                   solve(s1, s2, s3, i, j, k - 1, dp));
    }
    static int lcsOf3(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();

        // Create dp table and initialize with -1
        int[][][] dp = new int[i + 1][j + 1][k + 1];

        for (int x = 0; x <= i; x++) {
            for (int y = 0; y <= j; y++) {
                for (int z = 0; z <= k; z++) {
                    dp[x][y][z] = -1;
                }
            }
        }

        // Start solving from full lengths
        return solve(s1, s2, s3, i, j, k, dp);
    }
}