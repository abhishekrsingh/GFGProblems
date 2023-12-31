//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    string complement(string s){
        // code here
        for ( char& c : s ) c == '1' ? --c : ++c;
        for ( int i{ s.size()-1 }; i >= 0; --i )
            if ( s[ i ] == '1' ) --s[ i ];
            else { ++s[ i ]; break; }
        return s;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string bi;
        cin>>bi;
        
        Solution ob;
        cout<<ob.complement(bi)<<endl;
    }
    return 0;
}
// } Driver Code Ends