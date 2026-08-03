class Solution {
    private int mod = 1000000007;

    public int count(int n, int m) {
       
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long ans = 0;
                for (int k = 1; k <= m; k++) {
                    if (j % k == 0 || k % j == 0) {
                        ans = (ans + dp[i - 1][k]) % mod;
                    }
                }
                dp[i][j] = (int) ans;
            }
        }
        long totalWays = 0;
        for (int j = 1; j <= m; j++) {
            totalWays = (totalWays + dp[n][j]) % mod;
        }

        return (int) totalWays;
    }
}