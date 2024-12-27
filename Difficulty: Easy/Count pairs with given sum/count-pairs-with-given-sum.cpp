//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int countPairs(vector<int> &arr, int target) {
        unordered_map<int, int> freq;
        int cnt = 0;
    
        for (int i = 0; i < arr.size(); i++) {
          
            // Check if the complement (target - arr[i])
            // exists in the map. If yes, increment count
            if (freq.find(target - arr[i]) != freq.end()) {
                cnt += freq[target - arr[i]]; 
            }
          
            // Increment the frequency of arr[i]
            freq[arr[i]]++; 
        }
        return cnt;
    }
};

//{ Driver Code Starts.

int main() {
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
        int target;
        cin >> target;
        cin.ignore();
        Solution ob;
        int res = ob.countPairs(arr, target);

        cout << res << endl << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends