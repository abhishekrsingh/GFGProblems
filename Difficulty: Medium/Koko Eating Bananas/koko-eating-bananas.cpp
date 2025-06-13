class Solution {
  public:
    // Function to check if Koko can finish all bananas at speed 'mid' within 'k' hours
    bool finish(vector<int>& arr, int mid, int k) {
        int hours = 0;

        for (int i = 0; i < arr.size(); i++) {
            hours += arr[i] / mid;         // Add full chunks
            if (arr[i] % mid != 0) {
                hours++;                   // Add 1 hour for leftover bananas
            }
        }

        return hours <= k;  // Return true if total hours needed is within limit
    }
    
    int kokoEat(vector<int>& arr, int k) {
        int low    = 1;
        int high   = *max_element(arr.begin(), arr.end()); // Max bananas in a pile
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;  // Mid speed

            if (finish(arr, mid, k)) {
                result = mid;        // Try smaller speed
                high   = mid - 1;
            } else {
                low = mid + 1;       // Need to try faster speed
            }
        }

        return result;  // Minimum speed at which Koko can eat all bananas
    }
};