//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
public:
    std::vector<int> antiDiagonalPattern(std::vector<std::vector<int>>& matrix) {
        int num_rows = matrix.size();
        int num_cols = matrix[0].size();

        // Dictionary to store elements grouped by their anti-diagonal index
        std::unordered_map<int, std::vector<int>> anti_diagonal_groups;

        // Populate anti_diagonal_groups dictionary
        for (int i = 0; i < num_rows; ++i) {
            for (int j = 0; j < num_cols; ++j) {
                int anti_diagonal_index = i + j;
                anti_diagonal_groups[anti_diagonal_index].push_back(matrix[i][j]);
            }
        }

        std::vector<int> result;

        // Flatten the anti-diagonal groups into the final result list
        for (int i = 0; i < num_rows + num_cols - 1; ++i) {
            result.insert(result.end(), anti_diagonal_groups[i].begin(), anti_diagonal_groups[i].end());
        }

        return result;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> matrix;
        matrix.resize(n, vector<int>(n));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> matrix[i][j];
            }
        }

        Solution ob;
        vector<int> ans = ob.antiDiagonalPattern(matrix);
        for (int i = 0; i < ans.size(); ++i) cout << ans[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends