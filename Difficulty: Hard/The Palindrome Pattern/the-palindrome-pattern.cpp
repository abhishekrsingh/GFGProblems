//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:

    string pattern(vector<vector<int>> &arr) {
        // Code Here
        int ans1 = -1;    //first part of string
        char ans2='\0';    //second part of string
        int n=arr.size();
        
        //column checker
        for(int j=0; j<n; j++){
            bool flag=true;
            for(int i=0; i<n/2; i++){
                if(arr[i][j]!=arr[n-1-i][j]){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                ans1=j;
                ans2='C';
                break;
            }
            
        }
        //row checker
        for(int i=0; i<n; i++){
            bool flag=true;
            for(int j=0; j<n/2; j++){
                if(arr[i][j]!=arr[i][n-1-j]){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                ans1=i;
                ans2='R';
                break;
            }
        }
        
        if(ans1==-1){
            return "-1";
        }
        
        string rc_num = to_string(ans1);    //converting ans1 to string
        
        string st = rc_num + ' ' + ans2;
        
        return st;
    }
};


//{ Driver Code Starts.

int main() {

    int t, n, i, j, flag, k;
    cin >> t;

    while (t--) {
        cin >> n;
        vector<vector<int>> a(n, vector<int>(n));

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                cin >> a[i][j];
        }
        Solution ob;
        cout << ob.pattern(a) << endl;
    }
    return 0;
}
// } Driver Code Ends