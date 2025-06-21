class Solution {
    public boolean validgroup(int[] arr, int k) {
        int n = arr.length;
        TreeMap<Integer, Integer> mp = new TreeMap<>();  // frequency map

        // count each value
        for (int val : arr) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        // iterate in ascending order of keys
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int val  = entry.getKey();
            int freq = entry.getValue();

            if (freq == 0) {                // already used up
                continue;
            }

            // try to build freq sequences of length k starting at val
            for (int i = 1; i < k; i++) {
                int nextVal = val + i;

                int nextFreq = mp.getOrDefault(nextVal, 0);
                if (nextFreq < freq) {      // insufficient to continue all sequences
                    return false;
                }

                mp.put(nextVal, nextFreq - freq);
            }
        }

        return true;                       // all sequences formed successfully
    }
}