//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function template for C++

class Solution {
  public:
    int findMissing(vector<int> &arr) {
        // code here
        int n = arr.size();
  
        // If exactly one element is missing, then we can find
        // difference of arithmetic progression using following
        // formula.
        int diff = (arr[1] - arr[0] == arr[n-1] - arr[n-2]) ? arr[1] - arr[0] : 
              ((arr[1] - arr[0] == (arr[n-1] - arr[0])/n) ? arr[1] - arr[0] : 
               arr[n-1] - arr[n-2]);
        
        if(diff == 0)
            return arr[0];
        
      	int lo = 0, hi = n - 1;
      
        while (lo <= hi) {     
          	int mid = (lo + hi) / 2;
          
            // if mid == (nth position of element in AP)-1
            // the missing element will exist in right half 
            if ((arr[mid] - arr[0]) / diff == mid)
                lo = mid + 1;
          	
          	// the missing element will exist in left half
            else
                hi = mid - 1;
        }
      
        // after breaking out of binary search loop the missing element
      	// will exist between high and low
        return arr[hi] + diff;
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
        Solution ob;
        cout << ob.findMissing(arr) << "\n";
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends