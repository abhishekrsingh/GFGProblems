class Solution {
public:
    int findMaxProduct(vector<int>& arr) {

        const long long MOD = 1000000007;

        int n = arr.size();

        if (n == 1)
            return arr[0];

        int negCount = 0;
        int zeroCount = 0;

        long long product = 1;

        int maxNegative = INT_MIN;

        for (int x : arr) {

            if (x == 0) {
                zeroCount++;
                continue;
            }

            if (x < 0) {
                negCount++;
                maxNegative = max(maxNegative, x);
            }

            product = (product * x) % MOD;
        }

        // all zeros
        if (zeroCount == n)
            return 0;

        // only one negative and remaining zeros
        if (negCount == 1 && negCount + zeroCount == n)
            return 0;

        // odd negatives -> remove the negative closest to zero
        if (negCount % 2) {

            product = product * modInverse(maxNegative, MOD);
            product %= MOD;
        }

        if (product < 0)
            product += MOD;

        return product;
    }

    long long power(long long a, long long b, long long mod) {

        long long ans = 1;

        while (b) {

            if (b & 1)
                ans = (ans * a) % mod;

            a = (a * a) % mod;

            b >>= 1;
        }

        return ans;
    }

    long long modInverse(long long a, long long mod) {

        a %= mod;

        if (a < 0)
            a += mod;

        return power(a, mod - 2, mod);
    }
};
