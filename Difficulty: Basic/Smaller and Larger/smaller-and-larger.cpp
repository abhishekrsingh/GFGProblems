//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function template for C++
class Solution {
  public:
    vector<int> getMoreAndLess(vector<int> &arr, int target) {
        // code here
        int n = arr.size();

        // Count of elements less than or equal to target
        int left = 0, right = n - 1;
        int lessOrEqual = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                lessOrEqual = mid + 1;  // move right, include current mid
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        // Count of elements greater than or equal to target
        left = 0, right = n - 1;
        int greaterOrEqual = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                greaterOrEqual = n - mid;  // all elements from mid to end
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    
        return {lessOrEqual, greaterOrEqual};
    }
    
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // To ignore the newline character after the integer input
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int x;
        cin >> x;
        cin.ignore();
        Solution ob;
        vector<int> ans = ob.getMoreAndLess(arr, x);
        cout << ans[0] << " " << ans[1] << "\n~\n";
    }
    return 0;
}

// } Driver Code Ends