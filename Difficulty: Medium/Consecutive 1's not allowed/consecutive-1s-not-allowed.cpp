class Solution {
  public:
    int dp[45][2];
    int countStrings(int n) {
        memset(dp , -1 , sizeof(dp));
        return solve(n, 0);
    }
    
    int solve(int n, int prevBit){
        if(n == 0) return 1;
        if(dp[n][prevBit] != -1) return dp[n][prevBit];
        int placeOne = 0;
        if(!prevBit){ // place bit only if previous bit is 0 to avoid consecutive 
            placeOne = solve(n - 1, 1);
        }
        // can place everytime 
        int placeZero = solve(n - 1, 0);
        
        return dp[n][prevBit] =  placeOne + placeZero;
    }
};