class Solution {
    public int josephus(int n, int k) {
        int dp[]=new int[n+1];
        dp[0]=-1;
        for(int i=1;i<=n;i++){
            dp[i]=i;
        }
        
        int size=n;
        int idx=0;
       
        while(size>0){
          idx = (idx + k - 1) % size;
          for(int i=idx+1;i<size;i++){
              dp[i]=dp[i+1];
          }
          size--;
        }
        return dp[1];
    }
}