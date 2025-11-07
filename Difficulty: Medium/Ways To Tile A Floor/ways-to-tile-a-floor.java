class Solution {
    public int numberOfWays(int n) {
        // indirectly asking fibonacci number
        int[] dp = new int[n+1];
        
        if(n==1 || n==2) return n; // edge case
        
        // base initialization
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2]; // fibonacci
        }
        
        return dp[n]; // nth fibo
    }
};