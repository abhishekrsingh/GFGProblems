class Solution {
  public:
    // Memoization table to store subproblem results
    int dp[101][101][101]; // Max length for each string is 100, so 101 for 0-based indexing

    // Recursive function to find LCS
    int solve(string& s1, string& s2, string& s3, int i, int j, int k) {
        // Base case: if any string is empty, LCS is 0
        if (i == 0 || j == 0 || k == 0) {
            return 0;
        }

        // Return already computed result
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        // If current characters match in all three strings, include in LCS
        if (s1[i - 1] == s2[j - 1] && s2[j - 1] == s3[k - 1]) {
            return dp[i][j][k] = 1 + solve(s1, s2, s3, i - 1, j - 1, k - 1);
        }

        // Else, take max by excluding one character from one of the strings
        return dp[i][j][k] = max({
            solve(s1, s2, s3, i - 1, j, k),   // Exclude from s1
            solve(s1, s2, s3, i, j - 1, k),   // Exclude from s2
            solve(s1, s2, s3, i, j, k - 1)    // Exclude from s3
        });
    }
    // Main function to call the recursive solver
    int lcsOf3(string& s1, string& s2, string& s3) {
        int n1 = s1.size(), n2 = s2.size(), n3 = s3.size();

        // Initialize dp array with -1 to denote uncomputed states
        memset(dp, -1, sizeof(dp));

        // Start recursion with full lengths
        return solve(s1, s2, s3, n1, n2, n3);
    }
};
