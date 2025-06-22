class Solution {
  public:
    // Memoization table to store the best subsets
    vector<vector<vector<int>>> dp;

    // Helper function for recursion with memoization
    vector<int> solve(int idx, vector<int>& arr, int prev_idx) {
        // Base case: if idx is out of bounds, return an empty vector
        if (idx == arr.size()) {
            return {};
        }

        // If already computed, return the result from dp
        if (dp[idx][prev_idx + 1].size() > 0) {
            return dp[idx][prev_idx + 1];
        }

        // Option 1: Take arr[idx] if divisible by arr[prev_idx]
        vector<int> taken;
        if (prev_idx == -1 || arr[idx] % arr[prev_idx] == 0) {
            taken = solve(idx + 1, arr, idx);      // Take current element
            taken.insert(taken.begin(), arr[idx]); // Add current element to the result
        }

        // Option 2: Skip arr[idx]
        vector<int> not_take = solve(idx + 1, arr, prev_idx);  // Skip current element

        // Compare the result from both options and store the larger one
        vector<int> result = (not_take.size() > taken.size() || (not_take.size() == taken.size() && not_take > taken))
                              ? not_take : taken;

        // Memoize the result and return
        return dp[idx][prev_idx + 1] = result;
    }
    vector<int> largestSubset(vector<int>& arr) {
        int n = arr.size();

        sort(arr.begin(), arr.end());  // Sort the array to ensure lexicographical order

        // Initialize dp table once in the function
        dp = vector<vector<vector<int>>>(n, vector<vector<int>>(n + 1));

        // Start the recursion with no previous element (-1) and from index 0
        return solve(0, arr, -1);
    }
};