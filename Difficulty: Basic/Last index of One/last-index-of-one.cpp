//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int lastIndex(string s) {
        for(int i = s.length(); i >= 0; i--)
        {
            if(s[i] == '1') {
                return i;
                break;
            }
        }
        return -1;
    }
};


//{ Driver Code Starts.

int main() {
    long long t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.lastIndex(s) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends