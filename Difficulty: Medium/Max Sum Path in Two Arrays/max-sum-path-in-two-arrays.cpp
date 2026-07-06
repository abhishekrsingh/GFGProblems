class Solution {
  public:
    int maxPathSum(vector<int> &a, vector<int> &b) {
        // Code here
        int n = a.size(), m = b.size();
        int i = 0, j = 0;
        long long max_sum = 0, sum_a = 0, sum_b = 0; // Using long long avoids integer overflow
        
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sum_a += a[i];
                i++;
            } else if (b[j] < a[i]) {
                sum_b += b[j];
                j++;
            } else { // a[i] == b[j]
                max_sum += max(sum_a, sum_b) + a[i]; // Add the max bridge sum AND the common element
                sum_a = 0;
                sum_b = 0;
                i++;
                j++;
            }
        }
        
        // Drain any remaining elements from array a
        while (i < n) {
            sum_a += a[i];
            i++;
        }
        
        // Drain any remaining elements from array b
        while (j < m) {
            sum_b += b[j];
            j++;
        }
        
        // Add the final remaining segment's max
        max_sum += max(sum_a, sum_b);
        
        return max_sum;
    }
};