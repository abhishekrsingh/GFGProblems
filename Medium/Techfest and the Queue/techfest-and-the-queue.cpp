//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
public:
	int sumOfPowers(int a, int b){
	    // Code here
	    long sum = 0;

        for (int i = a; i <= b; i++) {
            int x = i;
            for (int j = 2; j * j <= x; j++) {
                while (x % j == 0) {
                    sum++;
                    x = x / j;
                }
            }
            if (x >= 2) sum++;
        }

        return sum;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int a, b;
		cin >>  a >> b;
		Solution obj;
		int ans = obj.sumOfPowers(a, b);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends