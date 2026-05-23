class Solution {
    public void cntOnesDFS(int x, int y, int[][] grid) {
        // Base Case
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if(grid[x][y] == 0) {
            return;
        }
        
        // LRUD
        grid[x][y] = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for(int i = 0; i < 4; i++) {
            cntOnesDFS(x + dx[i], y + dy[i], grid);
        }
        
        return;
    }

    public int cntOnes(int[][] grid) {
        int ans = 0;
        int rSize = grid.length;
        int cSize = grid[0].length;
        
        // DFS first & last row
        for(int i = 0; i < cSize; i++) {
            cntOnesDFS(0, i, grid);
            cntOnesDFS(rSize-1, i, grid);
        }
        
        // DFS first & last col
        for(int i = 0; i < rSize; i++) {
            cntOnesDFS(i, 0, grid);
            cntOnesDFS(i, cSize-1, grid);
        }
        
        // Counting leftover ones
        for(int[] r: grid) {
            for(int val: r) {
                if(val == 1) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
};