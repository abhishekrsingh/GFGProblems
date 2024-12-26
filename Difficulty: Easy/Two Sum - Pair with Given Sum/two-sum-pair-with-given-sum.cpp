//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    bool twoSum(vector<int>& arr, int target) {
        // Create an unordered_set to store the elements
        unordered_set<int> s;
    
        // Iterate through each element in the vector
        for (int i = 0; i < arr.size(); i++){
    
            // Calculate the complement that added to
            // arr[i], equals the target
            int complement = target - arr[i];
    
            // Check if the complement exists in the set
            if (s.find(complement) != s.end())
                return true;
    
            // Add the current element to the set
            s.insert(arr[i]);
        }
      
        // If no pair is found
        return false;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int x;
        cin >> x;
        cin.ignore();

        vector<int> arr;
        string input;
        getline(cin, input); // Read the entire line for the array elements
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        auto ans = ob.twoSum(arr, x);
        cout << (ans ? "true" : "false") << endl;
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends