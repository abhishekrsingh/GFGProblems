//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

// User function template for C++

class Solution {
  public:
    // int getOddOccurrence(int arr[], int n) {
    //     // code here
    //     int res = 0;
    //     for(int i = 0; i < n; i++)
    //     {
    //         res ^= arr[i];
    //     }
    //     return res;
    // }
    
    
    int getOddOccurrence(int arr[], int n) {
        // code here
        unordered_map<int, int> umap;
        for(int i = 0; i < n; i++)
        {
            umap[arr[i]]++;
        }
        for(auto i : umap)
        {
            if(i.second % 2 != 0) return i.first;
        }
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getOddOccurrence(arr, n);
        cout << ans << "\n";
    
cout << "~" << "\n";
}
    return 0;
}


// } Driver Code Ends