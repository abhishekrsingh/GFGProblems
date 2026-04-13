class Solution {
    public boolean isToeplitz(int[][] mat) {
        int r = mat.length; //Total number of rows
        int c = mat[0].length; //Total number of cols
        
        //Check if every ele matches its diagonal ele
        for(int i = 0;i < r - 1;i++){
            for(int j = 0;j < c - 1;j++){
                if(mat[i][j] != mat[i + 1][j + 1])
                return false;
            }
        }
        
        return true;
    }
}