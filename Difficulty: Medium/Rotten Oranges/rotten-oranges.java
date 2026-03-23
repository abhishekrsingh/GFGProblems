class Solution {
    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int orangesRot(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        int time = 0;
        while (!queue.isEmpty()) {
            if (freshOranges == 0) return time;
            int size = queue.size();
            while (size-- > 0) {
                int[] top = queue.poll();
                int row = top[0];
                int col = top[1];
                
                for (int[] dir : dirs) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    
                    if (isWithinBounds(mat, nRow, nCol) && mat[nRow][nCol] == 1) {
                        mat[nRow][nCol] = 2;
                        queue.offer(new int[]{nRow, nCol});
                        freshOranges--;
                    }
                }
                
            }
            time++;
        }
        
        return freshOranges == 0 ? time : -1;
        
    }
    
    private boolean isWithinBounds(int[][] mat, int row, int col) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }
}