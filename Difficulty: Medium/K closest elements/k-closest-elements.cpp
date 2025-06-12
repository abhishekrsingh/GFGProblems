class Solution {
  public:
    vector<int> printKClosest(vector<int> arr, int k, int x) {
        int n   = arr.size();
        int pos = -1;

        // Step 1: Binary Search to find last element < x
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                pos = mid; // update pos if arr[mid] is less than x
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Step 2: Two pointers: Pick k closest using distance comparison
        int left = pos, right = pos + 1;

        if (right < n && arr[right] == x) {
            right++;
        }

        vector<int> result;

        while (left >= 0 && right < n && result.size() < k) {
            int leftDiff  = abs(arr[left] - x);
            int rightDiff = abs(arr[right] - x);

            // Prefer the smaller difference; if tie, prefer the larger element
            if (leftDiff < rightDiff) {
                result.push_back(arr[left]);
                left--;
            } else {
                result.push_back(arr[right]);
                right++;
            }
        }

        // Fill remaining if any
        while (left >= 0 && result.size() < k) {
            result.push_back(arr[left]);
            left--;
        }

        while (right < n && result.size() < k) {
            result.push_back(arr[right]);
            right++;
        }

        return result;
    }
};