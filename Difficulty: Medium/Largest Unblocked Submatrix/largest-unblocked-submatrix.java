class Solution {
    public int largestArea(int n, int m, int[][] arr) {

        boolean[] blockedRow = new boolean[n];
        boolean[] blockedCol = new boolean[m];
    
        for (int[] cell : arr) {
            blockedRow[cell[0] - 1] = true;
            blockedCol[cell[1] - 1] = true;
        }
    
        int[][] grid = new int[n][m];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!blockedRow[i] && !blockedCol[j]) {
                    grid[i][j] = 1;
                }
            }
        }
    
        int ans = 0;
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, bfs(i, j, grid, n, m));
                }
            }
        }
    
        return ans;
    }
    
    int bfs(int sr, int sc, int[][] grid, int n, int m) {
    
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        grid[sr][sc] = 2;
    
        int cnt = 0;
    
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
    
            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
    
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    
        return cnt;
    }
}