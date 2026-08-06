class Solution {
  public:
    int countMinOperations(vector<int>& arr) {
        int totalSetBits = 0;
        int maxBitPosition = 0; // Tracks maximum double operations needed

        for (int x : arr) {
            int bitPos = 0;

            while (x > 0) {
                // If LSB is set, it represents a +1 operation
                if (x & 1) {
                    totalSetBits++;
                }
                x >>= 1;
                bitPos++;
            }

            // Number of double operations for value 'x' is (bitPos - 1)
            if (bitPos > 0) {
                maxBitPosition = max(maxBitPosition, bitPos - 1);
            }
        }

        return totalSetBits + maxBitPosition;
    }
};