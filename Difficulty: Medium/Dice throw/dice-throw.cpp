class Solution {
  public:
    int dp[51][51]; // Memoization table to store results of subproblems

    // Recursive function to calculate the number of ways to get sum 'x' with 'n' dice and 'm' faces
    int solve(int m, int n, int x) {
        if (x < 0) {
            return 0; // If the remaining sum is negative, no valid combination
        }

        if (dp[n][x] != -1) {
            return dp[n][x]; // Return previously computed result
        }

        if (n == 0 && x == 0) {
            return 1; // Base case: exact match of dice used and sum required
        }

        if (n == 0) {
            return 0; // No dice left but sum not reached
        }

        int result = 0;
        for (int faceVal = 1; faceVal <= m; faceVal++) {
            // Try all face values from 1 to m and recurse
            result += solve(m, n - 1, x - faceVal);
        }

        return dp[n][x] = result; // Store result in dp table
    }
    
    int noOfWays(int m, int n, int x) {
        memset(dp, -1, sizeof(dp)); // Initialize dp table with -1
        return solve(m, n, x);      // Start the recursive computation
    }
};