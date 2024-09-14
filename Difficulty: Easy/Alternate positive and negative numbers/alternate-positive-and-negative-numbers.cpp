//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    void rearrange(vector<int> &arr) {
        int n = arr.size();
        vector<int> v1, v2;
    
        // Separate positive and negative numbers
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0)
                v1.push_back(arr[i]);
            else
                v2.push_back(arr[i]);
        }
    
        int i = 0, j = 0, k = 0;
    
        // Fill the original array alternately with positive and negative numbers
        while(i < v1.size() && j < v2.size()) {
            if(k % 2 == 0)
                arr[k] = v1[i++];
            else
                arr[k] = v2[j++];
            k++;
        }
    
        // If there are remaining positive numbers
        while(i < v1.size()) {
            arr[k++] = v1[i++];
        }
    
        // If there are remaining negative numbers
        while(j < v2.size()) {
            arr[k++] = v2[j++];
        }
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
        int num;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }
        Solution ob;
        ob.rearrange(arr);
        for (int i = 0; i < arr.size(); i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends