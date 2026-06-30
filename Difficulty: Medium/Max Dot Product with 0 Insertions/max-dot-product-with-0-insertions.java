class Solution {
    int max(int a, int b) {
        return a > b ? a : b;
    }

    public int maxDotProduct(int[] a, int[] b) {
        int a_size = a.length;
        int b_size = b.length;

        int[] mem = new int[a_size];

        // Base case
        for (int y = 0; y <= a_size - b_size; y++) {
            mem[y] = a[y] * b[0];
        }

        // DP
        for (int x = 1; x < b_size; x++) {
            int y_limit = a_size - (b_size - x) + 1;

            int max_prev = mem[x - 1];

            for (int y = x; y < y_limit; y++) {
                int next = max(max_prev, mem[y]);
                mem[y] = a[y] * b[x] + max_prev;
                max_prev = next;
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int y = b_size - 1; y < a_size; y++) {
            ans = max(ans, mem[y]);
        }

        return ans;
    }
}