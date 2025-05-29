class Solution {
    public boolean ValidCorner(int[][] mat) {
        int m = mat.length;        // number of rows
        int n = mat[0].length;     // number of columns

        // Try all pairs of rows
        for (int r1 = 0; r1 < m; r1++) {
            for (int r2 = r1 + 1; r2 < m; r2++) {
                // Check for column pairs where both rows have 1
                for (int c1 = 0; c1 < n; c1++) {
                    for (int c2 = c1 + 1; c2 < n; c2++) {
                        // If all four corners are 1s, rectangle exists
                        if (mat[r1][c1] == 1 && mat[r1][c2] == 1 &&
                            mat[r2][c1] == 1 && mat[r2][c2] == 1) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;  // No valid rectangle found
    }
}