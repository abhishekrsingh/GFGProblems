//{ Driver Code Starts
// Initial function template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    bool isPossible(vector<int> &arr,int k,int mid){
        int sum=0,student=1;
        for(int x:arr){
            sum+=x;
            if(sum>mid){
                student++;
                sum=x;
            }
        }
        return student<=k;
    }
    int findPages(vector<int> &arr, int k) {
        // code here
        if(k>arr.size())return -1;
        int sum=0,mx=INT_MIN;
        for(int x:arr){
            sum+=x;
            mx=max(mx,x);
        }
        int low=mx,high=sum,mid,ans=INT_MAX;
        while(low<=high){
            mid=(low+high)/2;
            if(isPossible(arr,k,mid)){
                ans=min(ans,mid);
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
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
        int ans = ob.findPages(arr, d);
        cout << ans << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends