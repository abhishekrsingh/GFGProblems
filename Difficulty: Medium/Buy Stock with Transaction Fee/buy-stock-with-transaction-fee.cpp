class Solution {
  public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        
        int hold = -prices[0]; // bought first stock
        int cash = 0;          // no stock in hand
        
        for (int i = 1; i < n; i++) {
            // store previous cash (important)
            int prevCash = cash;
            
            // if we sell today
            cash = max(cash, hold + prices[i] - fee);
            
            // if we buy today
            hold = max(hold, prevCash - prices[i]);
        }
        
        return cash;
    }
};