//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	string removeDuplicates(string str) {
	    vector<char> v;
        unordered_map<char, int> umap;
        
        // Count occurrences of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.at(i);
            umap[ch]++;
        }
        
        // Collect unique characters
        for (int i = 0; i < str.length(); i++) {
            char ch = str.at(i);
            if (umap[ch] > 0) {
                v.push_back(ch);
                umap[ch] = 0; // Mark as visited
            }
        }
        
        // Return the result directly without storing it in a separate variable
        return string(v.begin(), v.end());
	}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string str;
        cin >> str;
        Solution ob;
        auto ans = ob.removeDuplicates(str);

        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends