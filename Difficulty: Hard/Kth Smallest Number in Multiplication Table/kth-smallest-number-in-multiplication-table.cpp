class Solution {
  public:
    // Function to count how many numbers are ≤ mid in the table
    int count(int mid, int m, int n) {
        int countSum = 0;

        for (int i = 1; i <= m; i++) {
            countSum += min(mid / i, n); // Each row contributes min(mid / i, n) elements
        }
        return countSum;
    }

    int kthSmallest(int m, int n, int k) {
        int l = 1;
        int h = m * n;

        while (l < h) {
            int mid = (l + h) / 2;

            if (count(mid, m, n) >= k) {
                h = mid;     // mid might be the answer
            } else {
                l = mid + 1; // ignore left half
            }
        }

        return l; // l is the k-th smallest number
    }
};
