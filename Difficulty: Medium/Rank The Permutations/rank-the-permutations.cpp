class Solution {
  public:
    long long findRank(string& s) {
        // code here
        int n = s.size();
        long long int fact[n+1] = {0},ans = 0;
        long long int rank[n] = {0};
        fact[0] = 1;
        for(int i=1; i<=n; i++)
        {
            fact[i] = fact[i-1]*i;
        }
        for(int i=0; i<n-1; i++)
        {
            int count = 0;
            for(int j=i+1; j<n; j++)
            {
                if(s[i]>s[j]) count++;
            }
            rank[i] = count;
        }
        for(int i=0; i<n; i++){
            ans += rank[i]*fact[n-1-i];
        }
        return ans+1;
    }
};