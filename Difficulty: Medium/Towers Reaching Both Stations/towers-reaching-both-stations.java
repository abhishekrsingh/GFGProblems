class Solution {
    class Tuple{
        int x;
        int y;
        int s;
        Tuple(int x,int y,int s)
        {
            this.x=x;
            this.y=y;
            this.s=s;
        }
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    void solve(int r,int c,int n,int m,int vis[][],int mat[][])
    {
        Queue<Tuple>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            q.add(new Tuple(i,c,mat[i][c]));
            vis[i][c]=1;
        }
        for(int j=0;j<m;j++)
        {
            q.add(new Tuple(r,j,mat[r][j]));
            vis[r][j]=1;
        }
        while(!q.isEmpty())
        {
            Tuple t=q.remove();
            int x=t.x;
            int y=t.y;
            int s=t.s;
            for(int i=0;i<4;i++)
            {
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==0 && mat[nx][ny]>=s)
                {
                    vis[nx][ny]=1;
                    q.add(new Tuple(nx,ny,mat[nx][ny]));
                }
            }
        }
    }
    public int countCoordinates(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        
        int vis1[][]=new int[n][m];
        solve(0,0,n,m,vis1,mat);
        int vis2[][]=new int[n][m];
        solve(n-1,m-1,n,m,vis2,mat);
        
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis1[i][j]==1 && vis2[i][j]==1)ans++;
            }
        }
        return ans;
    }
}