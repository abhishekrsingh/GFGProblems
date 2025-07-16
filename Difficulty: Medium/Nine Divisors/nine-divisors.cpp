class Solution {
  public:

    vector<int> sieve(int limit) {
        vector<bool> is_prime(limit + 1, true);
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i * i <= limit; ++i) {
            if (is_prime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        vector<int> primes;
        for (int i = 2; i <= limit; ++i) {
            if (is_prime[i]) {
                primes.push_back(i);
            }
        }
        return primes;
    }
    
    int countNumbers(int n) {
        int count = 0;
        
        // Check for numbers of the form p^8 where p is prime
        for (int p = 2; p <= (int)pow(n, 1.0 / 8) + 1; ++p) {
            long long num = 1;
            bool isPrime = true;
            // Check if p is prime
            if (p >= 2) {
                for (int i = 2; i * i <= p; ++i) {
                    if (p % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    num = 1;
                    for (int i = 0; i < 8; ++i) {
                        num *= p;
                        if (num > n) break;
                    }
                    if (num <= n) {
                        ++count;
                    }
                }
            }
        }
        
        // Check for numbers of the form p^2 * q^2 where p and q are distinct primes
        int sqrt_n = sqrt(n);
        vector<int> primes = sieve(sqrt_n);
        
        int primes_count = primes.size();
        for (int i = 0; i < primes_count; ++i) {
            long long p = primes[i];
            if (p * p > n) continue;
            for (int j = i + 1; j < primes_count; ++j) {
                long long q = primes[j];
                long long product = p * p * q * q;
                if (product > n) {
                    break;
                }
                ++count;
            }
        }
        
        return count;
    }
};