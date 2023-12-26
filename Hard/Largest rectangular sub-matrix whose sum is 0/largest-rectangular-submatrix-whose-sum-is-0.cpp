//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
  public:
  static vector<vector<int>> sumZeroMatrix(vector<vector<int>>& a) {
        int n = a.size(), m = a[0].size();
        int c1 = 0, c2 = 0, r1 = 0, r2 = 0, maxArea = -1001;

        for (int i = 0; i < m; i++) {
            vector<int> arr(n, 0);
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    arr[k] += a[k][j];
                }
                int s = 0, e = 0;
                int len = maxLen(arr, s, e);

                int area = (e - s + 1) * (j - i + 1);

                if (len > 0 && area > maxArea) {
                    r1 = s;
                    r2 = e;
                    c1 = i;
                    c2 = j;
                    maxArea = area;
                }
            }
        }

        vector<vector<int>> list;
        for (int i = r1; i <= r2; i++) {
            vector<int> ilist;
            for (int j = c1; j <= c2; j++) {
                ilist.push_back(a[i][j]);
            }
            list.push_back(ilist);
        }
        return list;
    }

private:
    static int maxLen(vector<int>& arr, int& s, int& e) {
        int sum = 0, mlen = 0;
        unordered_map<int, int> hm;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];

            if (arr[i] == 0 && mlen == 0) {
                s = i;
                e = i;
                mlen = 1;
            }
            if (sum == 0) {
                if (mlen < i + 1) {
                    s = 0;
                    e = i;
                }
                mlen = i + 1;
            }
            if (hm.find(sum) != hm.end()) {
                int plen = mlen;
                mlen = max(mlen, i - hm[sum]);

                if (mlen > plen) {
                    e = i;
                    s = hm[sum] + 1;
                }
            } else {
                hm[sum] = i;
            }
        }
        return mlen;
    }
};


//{ Driver Code Starts.




int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m;
        cin>>n>>m;
        
        vector<vector<int>> a(n,vector<int>(m));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin>>a[i][j];
            }
        }
        Solution ob;
        vector<vector<int>> ans = ob.sumZeroMatrix(a);
        if(ans.size() == 0){
            cout<<-1<<endl;
        }
        else{
            for(int i=0;i<ans.size();i++){
                for(int j=0;j<ans[0].size();j++){
                    cout<<ans[i][j]<<" ";
                }
                cout<<endl;
            }
        }
    }
    return 0;
}
// } Driver Code Ends