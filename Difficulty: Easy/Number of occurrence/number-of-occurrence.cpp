//{ Driver Code Starts
// Initial function template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int countFreq(vector<int>& arr, int target) {
        // code here
        int n = arr.size(), low=0, mid=0, high=n-1,firstIndex=-1, lastIndex=-1;
        for(int i=0;i<2;i++){
            low=0,high=n-1;
            while(low<=high){
                mid=(low+high)/2;
                if(arr[mid]==target){
                    if(i==0){
                        firstIndex=mid;
                        high=mid-1;
                    }
                    else{
                        lastIndex=mid;
                        low=mid+1;
                    }
                }
                else if(arr[mid]>target)high=mid-1;
                else low=mid+1;
            }
        }
        if(firstIndex==-1)return 0;
        return lastIndex-firstIndex+1;
    }
};


//{ Driver Code Starts.

int main() {
    int test_case;
    cin >> test_case;
    cin.ignore();
    while (test_case--) {

        int d;
        vector<int> arr, brr, crr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        getline(cin, input);
        ss.clear();
        ss.str(input);
        while (ss >> number) {
            crr.push_back(number);
        }
        d = crr[0];
        int n = arr.size();
        Solution ob;
        int ans = ob.countFreq(arr, d);
        cout << ans << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends