class Solution {
  public:
    vector<vector<int>> transpose(vector<vector<int>>& mat) {
        // code here
        int row = mat.size();
        int col = mat[0].size();
        for(int i=0; i<row; i++){
            for(int j=i; j<col; j++){
                swap(mat[i][j], mat[j][i]);
            }
        }
        return mat;
    }
};