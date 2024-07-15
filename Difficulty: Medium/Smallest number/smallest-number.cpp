//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    string smallestNumber(int s, int d) {
        // code here
        int temp,sum=0;
        int temp1;
        int Sdigit= pow(10,d-1);
        for(int i=Sdigit;i<(Sdigit*10);i++){
            temp1=i;
            sum=0;
            while(temp1>0){
               temp=temp1%10;
               sum +=temp;
               temp1=temp1/10;
            }
            if(sum==s) {
            return to_string(i);
            
        }
        }
        return to_string(-1);
    } 
};

//{ Driver Code Starts.

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int s, d;
        cin >> s >> d;
        Solution ob;
        cout << ob.smallestNumber(s, d) << "\n";
    }

    return 0;
}
// } Driver Code Ends