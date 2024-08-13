//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    int search(int n, int arr[]) {
        std::unordered_map<int, int> umap;
    
        // Count occurrences of each element
        for(int i = 0; i < n; i++) {
            umap[arr[i]]++;
        }
        
        // Find the first element that occurs exactly once
        for(auto i = umap.begin(); i != umap.end(); i++) {
            if(i->second == 1) {
                return i->first;
            }
        }
        
        // If no such element exists, return -1 (or any other value to signify not found)
        return -1;
    }
};

//{ Driver Code Starts.

// Driver program
int main() {
    int t, len;
    cin >> t;
    while (t--) {
        cin >> len;
        int arr[len];
        for (int i = 0; i < len; i++) {
            cin >> arr[i];
        }
        Solution ob;
        cout << ob.search(len, arr) << '\n';
    }
    return 0;
}

// } Driver Code Ends