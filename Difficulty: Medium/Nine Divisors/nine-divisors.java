class Solution {
    public static int countNumbers(int n) {
        int count = 0;

        // Check for numbers of the form p^8 where p is prime
        for (int p = 2; p <= Math.pow(n, 1.0 / 8) + 1; p++) {
            long num = 1;
            boolean isPrime = true;
            // Check if p is prime
            if (p >= 2) {
                for (int i = 2; i * i <= p; i++) {
                    if (p % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    num = 1;
                    for (int i = 0; i < 8; i++) {
                        num *= p;
                        if (num > n) break;
                    }
                    if (num <= n) {
                        count++;
                    }
                }
            }
        }

        // Check for numbers of the form p^2 * q^2 where p and q are distinct primes
        int sqrtN = (int) Math.sqrt(n);
        List<Integer> primes = sieve(sqrtN);

        int primesCount = primes.size();
        for (int i = 0; i < primesCount; i++) {
            long p = primes.get(i);
            if (p * p > n) continue;
            for (int j = i + 1; j < primesCount; j++) {
                long q = primes.get(j);
                long product = p * p * q * q;
                if (product > n) {
                    break;
                }
                count++;
            }
        }

        return count;
    }

    private static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}