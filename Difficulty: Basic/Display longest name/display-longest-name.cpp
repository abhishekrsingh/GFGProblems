//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    string longest(vector<string>& arr) {
        int n = arr.size();       // Get the size of the array
        string st;                // Variable to store the longest string
        int eleSize = 0;          // Variable to track the length of the longest string
    
        // Loop through each string in the array
        for(int i = 0; i < n; i++) {
            int len = arr[i].length();  // Get the length of the current string
            if(len > eleSize) {         // If current string is longer than previous longest
                st = arr[i];            // Update the longest string
                eleSize = len;          // Update the max length
            }
        }
        return st;  // Return the longest string found
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