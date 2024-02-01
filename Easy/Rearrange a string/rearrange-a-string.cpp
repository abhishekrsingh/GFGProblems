//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
  public:
    string arrangeString(string str)
    {
        //code here.
        // vector<char> mark(26, -1);
        // int sum = 0;
        // for(int i = 0; i < length(); i++)
        // {
        //     if ('A' <= str[i] && str[i] <= 'Z')
        //         int 
        // }
        string st = "";
        int sum = 0;
        sort(str.begin(), str.end());
        for(int i = 0; i < str.length(); i++)
        {
            if ('A' <= str[i] && str[i] <= 'Z')
                st += str[i];
            else
                sum += str[i] - '0';
        }
        string result = to_string(sum);
        if(sum == 0)
        {
            return st;
        }else{
            return st+result;
        }
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin >> t;
    while(t--){
        string s;
        cin >> s;
        Solution ob;
        cout <<ob.arrangeString(s) << endl;
    }
return 0;
}


// } Driver Code Ends