class Solution {
  public:
    void swapDiagonal(vector<vector<int>> &mat) {
        // code here
        int n = mat.size(); // Get the size of our square matrix
    
        // Go through each row
        for(int i = 0; i < n; i++) {
            // For row i:
            // - Major diagonal element is at column i
            // - Minor diagonal element is at column n-1-i
            
            // Swap the two elements
            swap(mat[i][i], mat[i][n-1-i]);
        }
    }
};
