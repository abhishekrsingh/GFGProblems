//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    string removeDups(string s) {
        int n = s.size();
        // frequency make its size 255 as per ASCII values
        vector<int> ch(255, 0);
    
        // Create result string
        string ans = "";
    
        for (int i = 0; i < n; i++) {
            // Check if current character's frequency is 0 or
            // not
            if (ch[s[i]] == 0) {
    
                // Add char if frequency is 0
                ans.push_back(s[i]);
    
                // Increment frequency by 1
                ch[s[i]]++;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;

        Solution ob;
        cout << ob.removeDups(s) << "\n";
    }

    return 0;
}
// } Driver Code Ends