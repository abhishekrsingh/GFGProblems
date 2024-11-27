//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to find the smallest positive number missing from the array.
    int missingNumber(vector<int> &arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
    
            // if arr[i] is within range [1, n] and arr[i] is
            // not placed at (arr[i]-1)th index in arr
            while (arr[i] >= 1 && arr[i] <= n
                   && arr[i] != arr[arr[i] - 1]) {
                       
                // then swap arr[i] and arr[arr[i]-1]
                // to place arr[i] to its corresponding index
                swap(arr[i], arr[arr[i] - 1]);
            }
        }
    
        // If any number is not at its corresponding index 
        // then it is the missing number
        for (int i = 1; i <= n; i++) {
            if (i != arr[i-1]) {
                return i;
            }
        }
    
        // If all number from 1 to n are present 
        // then n + 1 is smallest missing number
        return n + 1;
    }
};

//{ Driver Code Starts.

// int missingNumber(int arr[], int n);

int main() {

    // taking testcases
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int result = ob.missingNumber(arr);
        cout << result << "\n";
    }
    return 0;
}
// } Driver Code Ends