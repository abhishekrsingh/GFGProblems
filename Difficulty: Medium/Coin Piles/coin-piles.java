class Solution {
    // Custom upper_bound implementation (first index with value > target)
    private int upperBound(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;

        // Sort the array to process piles in increasing order
        Arrays.sort(arr);

        // Compute prefix sum array to calculate sum in range efficiently
        int[] prefix = new int[n];
        prefix[0]    = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int result = Integer.MAX_VALUE; // Store minimum coins to remove
        int prev   = 0;                 // Sum of coins to be removed from piles before index i

        for (int i = 0; i < n; i++) {
            // Find index of first element greater than arr[i] + k using binary search
            int idx = upperBound(arr, i, n, arr[i] + k);

            if (i > 0) {
                prev = prefix[i - 1]; // Coins to remove from all piles before i
            }

            // Coins to remove from all piles beyond idx that are > arr[i] + k
            int totalToRemove = prev + prefix[n - 1] - prefix[idx - 1] - (arr[i] + k) * (n - idx);

            // Update result with minimum coins to remove
            result = Math.min(result, totalToRemove);
        }

        return result;
    }
}
