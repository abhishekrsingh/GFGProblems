//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

bool isToeplitz(vector<vector<int>> &mat);

int main() {
    // your code goes here
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> a(n, vector<int>(m, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                cin >> a[i][j];
        }

        bool b = isToeplitz(a);

        if (b == true)
            cout << "true";
        else
            cout << "false";

        cout << endl;
    }
    return 0;
}
// } Driver Code Ends



bool isToeplitz(vector<vector<int>>& mat) {
    // Get the number of rows and columns in the matrix
    int rows = mat.size();
    int cols = mat[0].size();
    
    // Iterate through each element in the matrix except the last row and last column
    for (int i = 0; i < rows - 1; ++i) {
        for (int j = 0; j < cols - 1; ++j) {
            // Check if the current element is equal to the element in the next row and next column
            if (mat[i][j] != mat[i + 1][j + 1]) {
                // If any element does not match, the matrix is not a Toeplitz matrix
                return false;
            }
        }
    }
    
    // If all elements match their diagonal counterparts, the matrix is a Toeplitz matrix
    return true;
}