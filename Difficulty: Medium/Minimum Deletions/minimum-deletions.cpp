class Solution {
  public:
    int dp[1001][1001]; // Declare a memoization table to store results of subproblems

    // Recursive function to find minimum deletions to make s[i..j] a palindrome
    int solve(int i, int j, string& s) {
        // Base case: if left index crosses or meets right, it's already a palindrome
        if (i >= j) {
            return 0;
        }

        // Return cached result if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If both characters match, no need to delete, move inward
        if (s[i] == s[j]) {
            return dp[i][j] = solve(i + 1, j - 1, s);
        }

        // Else, try deleting one character (either from start or end) and take min
        return dp[i][j] = 1 + min(solve(i + 1, j, s), solve(i, j - 1, s));
    }

    // Main function
    int minDeletions(string s) {
        int n = s.length();

        // Initialize dp array with -1 (uncomputed)
        memset(dp, -1, sizeof(dp));

        // Compute result for the full string
        return solve(0, n - 1, s);
    }
};