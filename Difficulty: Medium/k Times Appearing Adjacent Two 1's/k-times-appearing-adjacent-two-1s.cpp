class Solution {
  public:
    int dp[2][1001][1001];
    int MOD=1000000007;
    int solve(int p, int n, int f, int k){
        if(n==0){
            return f==k;
        }
        if(dp[p][n][f]!=-1)return dp[p][n][f]%MOD;
        //put 0
        int t=solve(0,n-1,f,k);
        int nt=0;
        if(p==0)nt=solve(1,n-1,f,k);
        else if(f<k)nt=solve(1,n-1,f+1,k);
        
        return dp[p][n][f]=(t+nt)%MOD;
    }
    int countStrings(int n, int k) {
        // code here
        if(k>=n)return 0;
        memset(dp,-1,sizeof(dp));
        return (solve(0,n-1,0,k)%MOD+solve(1,n-1,0,k)%MOD)%MOD;     // we will call recursion two times, first element as 0 and then 1
    }
};