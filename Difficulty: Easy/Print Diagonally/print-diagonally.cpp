class Solution {
  public:
    vector<int> diagView(vector<vector<int>> mat) {
        // code here
        int n = mat.size();
        if (n == 0) return {};
        
        vector<int> result;
        result.reserve(n * n);
        
        for (int d = 0; d < 2 * n - 1; d++) {
            int row = max(0, d - n + 1);
            int col = min(d, n - 1);
            
            while (row < n && col >= 0) {
                result.push_back(mat[row++][col--]);
            }
        }
        
        return result;
    }
};