class Solution {
  public:
    vector<vector<int>> transpose(vector<vector<int>>& mat) {
        // code here
        int n = mat.size();
    
        // Create a new matrix of same size
        vector<vector<int>> result(n, vector<int>(n));
        
        // Compute transpose by swapping elements across the diagonal
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[j][i] = mat[i][j];
            }
        }
        
        return result;
    }
};