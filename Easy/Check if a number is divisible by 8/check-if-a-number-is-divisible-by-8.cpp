//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
    public:
    // int DivisibleByEight(string s){
    //     //code here
    //     int num=0;
    //     int i=s.length()-3>=0?s.length()-3:0;
    //     while(i<s.length()){
    //         num=num*10+(s[i]-'0');
    //         i++;
    //     }
    //     return num%8==0?1:-1;
    // }
    
    int DivisibleByEight(string s){
        int n=s.length();
        if(n<3){
            while(n<3){
                s='0'+s;
                n++;
            }
        }
        
        //our length is greater than equal to 3
        int number=0;
        for(int i=n-3;i<=n-1;i++){
            number=number*10+(s[i]-'0');
        }
        if(number%8==0){
            return 1;
        }
        else{
            return -1;
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
        string S;
        cin>>S;
        Solution ob;
        cout<<ob.DivisibleByEight(S)<<"\n";
    }
}
// } Driver Code Ends