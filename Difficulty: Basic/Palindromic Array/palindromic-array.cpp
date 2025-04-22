//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

/*Complete the function below*/

class Solution {
  public:
    bool isPalindrome(int n)
    {
        string s = to_string(n);
        int len = s.length();
        for(int i = 0; i < len/2; i++)
        {
            if(s[i] != s[len - 1 - i]) return false;
        }
        return true;
        
    }
    bool isPalinArray(vector<int> &arr) {
        // code here
        for (int i = 0; i < arr.size(); i++) {
        if (!isPalindrome(arr[i]))
            return false;
        }
        return true;
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
        getline(cin, input); // Read the entire line for the array elements
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;

        cout << (ob.isPalinArray(arr) ? "true" : "false") << endl;
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends