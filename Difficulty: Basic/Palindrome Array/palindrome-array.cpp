//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    bool isPerfect(vector<int> &arr) {
        // code here
        int n = arr.size();
        int i = 0, j = n-1;
        while(i < j)
        {
            if(arr[i] != arr[j]){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
};



//{ Driver Code Starts.

int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);

    while (t--) {
        string line;
        getline(cin, line);
        stringstream ss(line);
        vector<int> nums;
        int num;
        while (ss >> num) {
            nums.push_back(num);
        }

        Solution obj;
        bool res = obj.isPerfect(nums);

        if (res)
            cout << "true" << endl;
        else
            cout << "false" << endl;
    }
}

// } Driver Code Ends