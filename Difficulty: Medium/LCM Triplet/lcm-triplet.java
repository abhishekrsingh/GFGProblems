class Solution {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static long lcm3(long a, long b, long c) {
        long lcmAB = lcm(a, b);
        return lcm(lcmAB, c);
    }

    public static int lcmTriplets(int n) {
        if (n < 3) {
            return n; // For n=1,2, though triplet not possible, but problem says 1<=n<=1e3.
        }

        long maxLcm = 0;
        // Consider the top candidates to form triplets
        int[] candidates = {n, n - 1, n - 2, n - 3};
        int size = 4;

        // Generate all possible triplets from the candidates
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                for (int k = j + 1; k < size; ++k) {
                    int a = candidates[i];
                    int b = candidates[j];
                    int c = candidates[k];
                    if (a >= 1 && b >= 1 && c >= 1) {
                        long currentLcm = lcm3(a, b, c);
                        if (currentLcm > maxLcm) {
                            maxLcm = currentLcm;
                        }
                    }
                }
            }
        }
        return (int) maxLcm;
    }
}