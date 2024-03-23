//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    vector<int> Series(int n) {
        
        int mod = 1000000007;
        vector <int> ans;
        ans.push_back(0);
        if( n == 0 ) return ans;
        
        ans.push_back(1);
        if(n == 1 )  return ans;
        
        int prev = 0;
        int cur = 1;
        
        for(int i = 2; i <= n ;i++)
        {
            int next = (cur + prev)%mod;
            prev = cur%mod;
            cur = next%mod;
            ans.push_back(next);
        }
        
        return ans;
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution obj;

        vector<int> ans = obj.Series(n);
        for (auto x : ans) cout << x << " ";
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends