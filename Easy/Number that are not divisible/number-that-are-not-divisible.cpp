//{ Driver Code Starts


#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution {
  public:
    long long noOfNumbers(long long N) {
        //Important to note that only 2,3,5,7 are the key no here and rest are multiple of them.
        long long a=N/7-N/14-N/21-N/35+N/42-N/210+N/70+N/105;
        long long b=N/5-N/10-N/15+N/30;
        long long c=N/3-N/6;
        long long d=N/2;
        return N-(a+b+c+d);
        //Here a is total no which divisible by 7 but not by 2,3,5;
        //Here b is total no which divisible by 5 but not by 2,3;
        //Here c is total no which divisible by 3 but not by 2;
        //Here d is total no which is divisible by 2.
   }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long N;
        
        cin>>N;

        Solution ob;
        cout << ob.noOfNumbers(N) << endl;
    }
    return 0;
}
// } Driver Code Ends