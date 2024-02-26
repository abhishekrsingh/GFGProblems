//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
		void help(string s,int index,vector<string> &ans,string temp){
	        if(index==s.length()){
	            if(temp.length())ans.push_back(temp);
	            return;
	        }
	        help(s,index+1,ans,temp);
	        temp+=s[index];
	        help(s,index+1,ans,temp);
	    }
		vector<string> AllPossibleStrings(string s){
		    // Code here
		    vector<string> ans;
		    help(s,0,ans,"");
		    sort(ans.begin(),ans.end());
		    return ans;
		}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string s;
		cin >> s;
		Solution ob;
		vector<string> res = ob.AllPossibleStrings(s);
		for(auto i : res)
			cout << i <<" ";
		cout << "\n";

	}
	return 0;
}
// } Driver Code Ends