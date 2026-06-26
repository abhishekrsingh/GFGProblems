class Solution {
  public:
    int countWays(string &s1, string &s2) {
        // code here
        int n = s1.size();
        int m = s2.size();
        int MOD = 1e9 + 7;
    
        // dp[n+1][m+1] ki matrix banayi aur sabko 0 se initialize kiya
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
    
        // Base Case: Agar s2 khali hai (j = 0), toh hamesha 1 tareeqa hota hai (khali subsequence)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
    
        // DP Table ko fill karna shuru karte hain
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                // Agar characters match ho gaye (i-1 aur j-1 string indexing ke liye hain)
                if (s1[i - 1] == s2[j - 1]) {
                    // pichla character match liya (dp[i-1][j-1]) + isko ignore kiya (dp[i-1][j])
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } 
                else {
                    // Agar match nahi hua, toh s1 ka pichla state hi copy hoga
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    
        // Final answer matrix ke aakhiri cell mein hoga
        return dp[n][m];
    }
};
