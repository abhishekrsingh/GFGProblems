//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    int minValue(string s, int k){
        // code here
        unordered_map<char,int> mm;
        for(auto x:s)mm[x]++;
        priority_queue<int> pq;
        for(auto x:mm)pq.push(x.second);
        int ans = 0;
        while(k--){
            int temp = pq.top();
            pq.pop();
            temp--;
            pq.push(temp);
        }
        while(pq.size()){
            int temp = pq.top();
            pq.pop();
            ans+=temp*temp;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string s;
        int k;
        cin>>s>>k;
        
        Solution ob;
        cout<<ob.minValue(s, k)<<"\n";
    }
    return 0;
}
// } Driver Code Ends