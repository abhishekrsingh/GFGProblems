class Solution {
    static int[][] dp; // Memoization table

    // Recursive function to find minimum deletions to make s[i..j] a palindrome
    static int solve(int i, int j, String s) {
        // Base case: if left index crosses or meets right, it's already a palindrome
        if (i >= j) {
            return 0;
        }

        // Return cached result if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If both characters match, no need to delete, move inward
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(i + 1, j - 1, s);
        }

        // Else, try deleting one character (either from start or end) and take min
        return dp[i][j] = 1 + Math.min(solve(i + 1, j, s), solve(i, j - 1, s));
    }
    
    // Main function to be called
    static int minDeletions(String s) {
        int n = s.length();

        dp = new int[n][n];

        // Initialize dp array with -1 (uncomputed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // Compute result for the full string
        return solve(0, n - 1, s);
    }
}