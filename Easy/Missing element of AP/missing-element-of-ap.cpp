//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{   
public:
    int findMissing(int arr[], int n) {
        int diff = (arr[n - 1] - arr[0]) / n; // Calculate the common difference

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                return arr[i] + diff; // Found the missing element
            }
        }
        return -1; // If no missing element found (or array is empty), return -1 or any appropriate value
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
        auto ans = ob.findMissing(arr, n);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends