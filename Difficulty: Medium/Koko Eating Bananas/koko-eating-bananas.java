class Solution {
    // Helper function to check if Koko can finish all bananas at speed 'mid' within 'k' hours
    private boolean canFinish(int[] arr, int mid, int k) {
        int hours = 0;

        for (int bananas : arr) {
            hours += bananas / mid;
            if (bananas % mid != 0) {
                hours++; // Add extra hour if leftover bananas exist
            }
        }

        return hours <= k;
    }

    public int kokoEat(int[] arr, int k) {
        int low  = 1;
        int high = Integer.MIN_VALUE;

        // Find the maximum number in the array
        for (int bananas : arr) {
            high = Math.max(high, bananas);
        }

        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canFinish(arr, mid, k)) {
                result = mid;       // Try smaller speed
                high   = mid - 1;
            } else {
                low = mid + 1;      // Try higher speed
            }
        }

        return result;
    }
}
