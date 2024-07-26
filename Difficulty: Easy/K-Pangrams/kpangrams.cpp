//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:

    bool kPangram(string str, int k) {
        unordered_set<char> st;
        int cntSps = 0;
        for(auto ch : str) 
        {    
            if(ch != ' ')
               st.insert(ch);
            else
               cntSps++;
        }
        
        if(26 - st.size() <= k && str.size()-cntSps >= 26) return true;
        
        return false;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        cin.ignore();
        string str;
        getline(cin, str);

        int k;
        cin >> k;

        Solution ob;
        bool a = ob.kPangram(str, k);
        if (a)
            cout << "true" << endl;
        else
            cout << "false" << endl;
    }
    return 0;
}
// } Driver Code Ends