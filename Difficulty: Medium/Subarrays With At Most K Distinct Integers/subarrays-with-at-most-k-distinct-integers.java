class Solution {
    public int countAtMostK(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>(); // to store frequency of elements in current window

        int i      = 0;                             // left boundary of sliding window
        int j      = 0;                             // right boundary of sliding window
        int result = 0;                             // total number of valid subarrays

        while (j < n) {
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1); // include arr[j] in the window

            while (mp.size() > k) {                         // if distinct elements exceed k, shrink window from left
                mp.put(arr[i], mp.get(arr[i]) - 1);
                if (mp.get(arr[i]) == 0) {
                    mp.remove(arr[i]); // remove element with 0 frequency
                }
                i++;                   // move left pointer to right
            }

            result += (j - i + 1);   // count subarrays ending at j with at most k distinct elements
            j++;                     // expand window to the right
        }
        return result;
    }
}
