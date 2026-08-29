class Solution {
    public int minCost(int[][] mat) {
         int n = mat.length;
         for (int i = 1; i < n; i++) {
             mat[i][0] = Math.min(mat[i][0] + mat[i - 1][1], mat[i][0] + mat[i - 1][2]);
             mat[i][1] = Math.min(mat[i][1] + mat[i - 1][0], mat[i][1] + mat[i - 1][2]);
             mat[i][2] = Math.min(mat[i][2] + mat[i - 1][0], mat[i][2] + mat[i - 1][1]);
         }

         return Math.min(mat[n - 1][0], Math.min(mat[n - 1][1], mat[n - 1][2]));
     }
}