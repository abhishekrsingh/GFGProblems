//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int findMin(vector<int>& arr) {
        int lo = 0, hi = arr.size() - 1;

        while (lo < hi) {
          
            // The current subarray is already sorted, 
            // the minimum is at the low index
            if (arr[lo] < arr[hi])        
                return arr[lo];
               
            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
          
            int mid = (lo + hi) / 2;
    
            // The right half is not sorted. So 
            // the minimum element must be in the
            // right half.
            if (arr[mid] > arr[hi])
                lo = mid + 1;
          
            // The right half is sorted. Note that in 
            // this case, we do not change high to mid - 1
            // but keep it to mid. As the mid element
            // itself can be the smallest
            else
                hi = mid;
        }
    
        return arr[lo];
    }
};

//{ Driver Code Starts.

int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);

    Solution ob;
    while (t--) {
        string line;
        getline(cin, line);
        stringstream ss(line);
        vector<int> nums;
        int num;
        while (ss >> num) {
            nums.push_back(num);
        }
        cout << ob.findMin(nums) << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends