//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int evaluate(vector<string>& arr) {
        int n=arr.size();
        stack<int>st;
        for(int i=0;i<n;i++){
            if(arr[i]!="*" && arr[i]!="/" && arr[i]!="-" && arr[i]!="+"){
                string s=arr[i];
                int x=s.length();
                int num=0;
                int flag=0;
                int i=0;
                if(s[i]=='-'){
                    flag=1;
                    i++;
                    x--;
                }
                while(x--){
                    num=num*10+(s[i]-'0');
                    i++;
                }
                if(flag==1) num=-1*num;
                st.push(num);
            }else{
                int b=st.top();
                st.pop();
                int a=st.top();
                st.pop();
                int c;
                if(arr[i]=="*") c=a*b;
                else if(arr[i]=="/") c=a/b;
                else if(arr[i]=="-") c=a-b;
                else if(arr[i]=="+") c=a+b;
                st.push(c);
            }
        }
        return st.top();
    }
};


//{ Driver Code Starts.

int main() {
    string str;
    getline(cin, str);
    int t = stoi(str);
    while (t--) {
        getline(cin, str);
        stringstream ss(str);
        vector<string> arr;
        while (ss >> str) {
            arr.push_back(str);
        }
        Solution ob;
        cout << ob.evaluate(arr) << endl;
        cout << "~" << endl;
    }
}
// } Driver Code Ends