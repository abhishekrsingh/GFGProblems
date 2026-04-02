class Solution {
  public:
    int countWays(int n, int k) {
        // code here
        if (n == 1) return k;
    
        long long prev2 = k;          // total[1]
        long long prev1 = (long long)k * k;  // total[2]
        
        for (int i = 3; i <= n; ++i) {
            long long curr = (k - 1) * (prev1 + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return (int)prev1;  // for n≥2, answer is prev1; for n=1 we already returned
    }
};