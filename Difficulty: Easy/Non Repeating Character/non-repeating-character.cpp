//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to find the first non-repeating character in a string.
    // Function to find the first non-repeating character in a string.
    const int MAX_CHAR = 26;
    char nonRepeatingChar(string &s) {
        vector<int> vis(MAX_CHAR, -1);

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
    
            // If the character is seen for the first time,
            // store its index
            if (vis[s[i] - 'a'] == -1)
                vis[s[i] - 'a'] = i;
    
            // If the character is seen again, mark it as -2
            else
                vis[s[i] - 'a'] = -2;
        }
    
        int idx = INT_MAX;
        
        // Find the smallest index among all non-repeating 
        // characters
        for (int i = 0; i < MAX_CHAR; i++) {
            if (vis[i] >= 0)
                idx = min(idx, vis[i]);
        }
      
        // If non-repeating character is found, return it 
        // Else return '$'
        return (idx == INT_MAX ? '$' : s[idx]);
    }
};

//{ Driver Code Starts.

int main() {

    int T;
    cin >> T;

    while (T--) {

        string S;
        cin >> S;
        Solution obj;
        char ans = obj.nonRepeatingChar(S);

        if (ans != '$')
            cout << ans;
        else
            cout << "-1";

        cout << endl;

        cout << "~"
             << "\n";
    }

    return 0;
}

// } Driver Code Ends