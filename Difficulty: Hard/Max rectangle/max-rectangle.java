class Solution {
    static class Node{
        int r;
        int c;
        
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int maxArea(int mat2[][]) {
        // code here
        int n = mat2.length;
        int m = mat2[0].length;
        Node[][] mat = new Node[n][m];
        int max = 0;
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(mat2[i][j] == 0) mat[i][j] = new Node(0,0);
                else{
                    int r = j+1 < m ? mat[i][j+1].r+1 : 1;
                    int c = i+1 < n ? mat[i+1][j].c+1 : 1;
                    mat[i][j] = new Node(r,c);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j].r == 0) continue;
                
                int min = Integer.MAX_VALUE;
                
                for(int l = j; l < m && l < (l+mat[i][l].r); l++){
                    min = Math.min(min,mat[i][l].c);
                    int h = mat[i][j].r - mat[i][l].r + 1;
                    int area = h*min;
                    max = Math.max(max,area);
                }
            }
        }
        
        return max;
    }
}