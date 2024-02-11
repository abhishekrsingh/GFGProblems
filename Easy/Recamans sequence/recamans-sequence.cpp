//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    vector<int> recamanSequence(int n){
        int pre=0;
        if(n==0)
        return {0};
        
        vector<int> ans;
        unordered_map<int,int> mp;
        ans.push_back(0);
        mp[0]=1;
        for(int i=1;i<=n;i++)
        {
            int curr=pre-i;
            if(curr<0 or mp.count(curr))
            curr+=(2*i);
            
            ans.push_back(curr);
            mp[curr]=1;
            pre=curr;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        
        Solution ob;
        vector<int> ans = ob.recamanSequence(n);
        for(int i = 0;i < n;i++)
            cout<<ans[i]<<" ";
        cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends