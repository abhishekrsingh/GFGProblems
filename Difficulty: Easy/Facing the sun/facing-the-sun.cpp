//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    // Returns count buildings that can see sunlight
    int countBuildings(vector<int> &height) {
        int n = height.size();
        if (n == 0) return 0; // Edge case for empty vector
        
        int count = 1; // First building is always visible
        int lastVisible = height[0]; // Height of the first visible building
        
        for (int i = 1; i < n; i++) {
            if (height[i] > lastVisible) {
                count++; // Current building is taller than the last visible one
                lastVisible = height[i]; // Update last visible building
            }
        }
        
        return count;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> height;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            height.push_back(number);
        }
        Solution ob;
        int ans = ob.countBuildings(height);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends