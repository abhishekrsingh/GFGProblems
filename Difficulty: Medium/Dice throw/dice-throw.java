class Solution {
    static int[][] dp = new int[51][51];

    static int solve(int m, int n, int x) {
        if (x < 0) {
            return 0; // Invalid path if remaining sum is negative
        }

        if (dp[n][x] != -1) {
            return dp[n][x]; // Return cached result
        }

        if (n == 0 && x == 0) {
            return 1; // Base case: exact sum and exact dice used
        }

        if (n == 0) {
            return 0; // No dice left but sum not matched
        }

        int result = 0;
        for (int faceVal = 1; faceVal <= m; faceVal++) {
            result += solve(m, n - 1, x - faceVal); // Try all face values
        }

        return dp[n][x] = result; // Memoize and return
    }

    static int noOfWays(int m, int n, int x) {
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                dp[i][j] = -1; // Initialize dp array
            }
        }
        return solve(m, n, x); // Start solving
    }
};