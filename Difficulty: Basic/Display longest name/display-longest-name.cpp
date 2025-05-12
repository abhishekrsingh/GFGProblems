//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    string longest(vector<string>& arr) {
        // code here
        int n = arr.size();
        string st;
        int eleSize = 0;
        for(int i = 0; i < n; i++)
        {
            int len = arr[i].length();
            if(len > eleSize)
            {
                st = arr[i];
                eleSize = len;
            }
        }
        return st;
    }
};



//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<string> names;
        string input1;
        getline(cin, input1);
        stringstream ss1(input1);
        string str;
        while (ss1 >> str) {
            names.push_back(str);
        }
        Solution obj;
        string res = obj.longest(names);
        cout << res << "\n~\n";
    }
}

// } Driver Code Ends