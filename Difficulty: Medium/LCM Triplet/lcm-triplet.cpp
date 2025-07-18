class Solution {
  public:
    long long gcd(long long a, long long b) {
        while (b != 0) {
            long long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    long long lcm(long long a, long long b) {
        return (a / gcd(a, b)) * b;
    }
    
    long long lcm3(long long a, long long b, long long c) {
        long long lcm_ab = lcm(a, b);
        return lcm(lcm_ab, c);
    }
    
    int lcmTriplets(int n) {
        if (n < 3) {
            return n; // For n=1,2, though triplet not possible, but problem says 1<=n<=1e3.
        }
        
        long long max_lcm = 0;
        // Consider the top candidates to form triplets
        int candidates[] = {n, n-1, n-2, n-3};
        int size = 4;
        
        // Generate all possible triplets from the candidates
        for (int i = 0; i < size; ++i) {
            for (int j = i+1; j < size; ++j) {
                for (int k = j+1; k < size; ++k) {
                    int a = candidates[i];
                    int b = candidates[j];
                    int c = candidates[k];
                    if (a >= 1 && b >= 1 && c >= 1) {
                        long long current_lcm = lcm3(a, b, c);
                        if (current_lcm > max_lcm) {
                            max_lcm = current_lcm;
                        }
                    }
                }
            }
        }
        return max_lcm;
    }
};