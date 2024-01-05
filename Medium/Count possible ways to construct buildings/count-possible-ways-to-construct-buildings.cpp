//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	const long long mod = 1000000007;

    int TotalWays(int N) {
        vector<long long> fib(N + 1, 0);

        // Initialize the first two elements
        fib[0] = 2;
        fib[1] = 3;

        // Calculate Fibonacci series
        for (int i = 2; i <= N - 1; i++) {
            fib[i] = (fib[i - 1] % mod + fib[i - 2] % mod) % mod;
        }

        return static_cast<int>((fib[N - 1] * fib[N - 1]) % mod);
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution ob;
		int ans = ob.TotalWays(N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends