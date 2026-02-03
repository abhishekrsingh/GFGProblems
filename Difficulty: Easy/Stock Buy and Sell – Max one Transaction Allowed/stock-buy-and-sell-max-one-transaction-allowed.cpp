class Solution {
  public:
    int maxProfit(vector<int> &prices) {
        // code here
        int n=prices.size(),buy=prices[0],profit=0;
        for(int i=1;i<n;i++){
            if(prices[i]<=buy){
                buy=prices[i];
            }
            else{
                profit=max(profit,prices[i]-buy);
            }
        }
        return profit;
    }
};
