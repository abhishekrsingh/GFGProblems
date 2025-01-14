//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int transitionPoint(vector<int>& arr) {
        int s=0, e=arr.size();
        while(s<e){
            int mid = s + (e-s)/2;
            if(arr[mid] == 1 && arr[mid-1] == 0)
            {
                return mid;
            }else if(arr[mid] == 0){
                s++;
            }else{
                e--;
            }
        }
        return -1;
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
        cout << ob.transitionPoint(arr) << endl;

        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends