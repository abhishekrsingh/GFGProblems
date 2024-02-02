//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{
  public:
    /*You are required to complete this method */
    int atoi(string s) {
        int ans = 0;
        int i = 0;
        bool flag = true;
        
        if(s[0] =='-'){
            flag = false;
            i = 1;
        }
        
        for(i;i<s.size();i++){
            
            if(s[i]>='0' && s[i]<='9'){
                int val = (s[i])-'0';
                ans = ans*10 + val;
                // cout<<s[i]<<" : "<<ans<<endl;
            }else{
                return -1;
            }
        }
        
        if(flag == false){
            return -1*ans;
        }else{
            return ans;
        }
    }
};

//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		cin>>s;
		Solution ob;
		cout<<ob.atoi(s)<<endl;
	}
}
// } Driver Code Ends