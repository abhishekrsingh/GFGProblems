class Solution {
  public:
    virtual int fun(int n, vector<int> &dp){
      if(n<=6) return n;
      if(dp[n]!=-1) return dp[n];
      
      int ans=INT_MIN;
      for(int j=1; j<=(n-3); j++){
        ans=max(ans, fun(j, dp)*(n-1-j));  
      }
      
      return dp[n]=ans;
      
    }
    virtual int optimalKeys(int n){
      vector<int> dp(n+1, -1);    
      return fun(n, dp);
    }
};