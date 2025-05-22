class Solution {
    public int count(int mid, int m, int n) {
        int countSum = 0;

        for (int i = 1; i <= m; i++) {
            countSum += Math.min(mid / i, n); // Count how many elements in row i are ≤ mid
        }
        return countSum;
    }
    
    public int kthSmallest(int m, int n, int k) {
        int l = 1;
        int h = m * n;

        while (l < h) {
            int mid = (l + h) / 2;

            if (count(mid, m, n) >= k) {
                h = mid;     // mid might be part of the result
            } else {
                l = mid + 1; // look in the right half
            }
        }

        return l; // l will be the smallest number with at least k elements ≤ it
    }
}