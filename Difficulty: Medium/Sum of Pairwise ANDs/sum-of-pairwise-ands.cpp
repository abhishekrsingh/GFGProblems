#define ll long long
class Solution {
	public:
	long long pairAndSum(vector<int> &arr) {
		// code here
		ll ans = 0;
		for (ll i = 0; i < 63; i++) {
			ll cnt = 0;
			for (ll it : arr) {
				if ((it&(1LL << i)))
					cnt++;
			}
			ans += (cnt)*(cnt - 1)*(1LL << i)/2;
		}
		return ans;
	}
};
