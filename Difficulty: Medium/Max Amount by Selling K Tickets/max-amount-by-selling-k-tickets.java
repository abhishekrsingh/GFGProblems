class Solution {
    private static long MOD = 1000000007l;
    
    int max (int a, int b) { return a > b ? a : b; }

    public int maxAmount(int[] arr, int k) {
        int n = arr.length;
        int m = 0;
    
        Map<Integer, Integer> f = new HashMap<>();
        for (int x = 0; x < n; x++) {
            int d = arr[x];
            f.put(d, f.getOrDefault(d, 0) + 1);
            m = Math.max(d, m);
        }
    
        long s = 0;
        long carry = 0;
    
        while (k > 0 && m > 0) {
            long m_t = f.getOrDefault(m, 0) + carry;
            
            if (m_t >= k) {
                s = (s + (long) m * k) % MOD;
            } else {
                s = (s + (long) m * m_t) % MOD;
            }
    
            k -= m_t;
            carry = m_t;
            m--;
        }
    
        return (int) s;
    }
}