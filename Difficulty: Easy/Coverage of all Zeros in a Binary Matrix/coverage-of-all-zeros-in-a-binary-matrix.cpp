//{ Driver Code Starts


#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    int findCoverage(vector<vector<int>>&matrix){
       
        int coverage, i, j, rows, columns;
        
        rows = matrix.size();
        columns = matrix[0].size();
        coverage = 0;
        
        for(i=0; i<rows; i++)
        {
            for(j=0; j<columns; j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(i-1 >= 0) coverage += matrix[i-1][j];
                    if(j-1 >= 0) coverage += matrix[i][j-1];
                    if(i+1 <= rows-1) coverage += matrix[i+1][j];
                    if(j+1 <= columns-1) coverage += matrix[i][j+1];
                }
            }
        }
        
        return coverage;
    }
};


//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> matrix(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cin >> matrix[i][j];
        Solution obj;
        int ans = obj.findCoverage(matrix);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends