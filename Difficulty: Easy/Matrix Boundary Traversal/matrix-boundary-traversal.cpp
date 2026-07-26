class Solution {
  public:
    vector<int> boundaryTraversal(vector<vector<int>>& mat) {
        // code here
        int row = mat.size();
        int col = mat[0].size();
        vector<int> result;
        //single row matrix edge case
        if(row == 1){
            for(int j=0; j<col; j++){
                result.push_back(mat[0][j]);
            }
            return result;
        }
        //single column matrix edge case
        if(col == 1){
            for(int j=0; j<row; j++){
                result.push_back(mat[j][0]);
            }
            return result;
        }
        
        for(int j=0; j<col; j++){
            result.push_back(mat[0][j]);
        }
        for(int j=1; j<row; j++){
            result.push_back(mat[j][col-1]);
        }
        for(int j=col-2; j>=0; j--){
            result.push_back(mat[row-1][j]);
        }
        for(int j=row-2; j>=1; j--){
            result.push_back(mat[j][0]);
        }
        return result;
    }
};
