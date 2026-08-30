class Solution {
    public int countSubsequences(String s, int n) {
         // code here
         long mod = 1_000_000_007;
         long dp[]=new long[n];
         for(char ch:s.toCharArray()){
             int cur=ch-'0';
             long newdp[]=dp.clone();
             int rem=cur%n;
             newdp[rem]=(newdp[rem]+1)%mod;
             for(int r=0;r<n;r++){
                 int newr=(r*10+cur)%n;
                 newdp[newr]=(newdp[newr]+dp[r])%mod;
             }
             dp=newdp;
         }
         return (int)dp[0];
     }
}