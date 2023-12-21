//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{   
public:
    int getPairsCount(int arr[], int n, int k) {
        // code here
        int result = 0;
        unordered_map<int, int>umap;
        for(int i = 0; i < n; i++)
        {
            if(umap.find(k-arr[i]) != umap.end())
            {
                result += umap[k-arr[i]];
            }
            umap[arr[i]]++;
        }
        return result;
    }
    
    //T.C -> o(n^2)
    // int getPairsCount(int arr[], int n, int k) {
    //     // code here
    //     int result = 0;
    //     for(int i = 0; i < n; i++)
    //     {
    //         for(int j = i+1; j < n; j++)
    //         {
    //             if(arr[i] + arr[j] == k) result++;
    //         }
    //     }
    //     return result;
    // }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getPairsCount(arr, n, k);
        cout << ans << "\n";
    }
    
    return 0;
}
// } Driver Code Ends