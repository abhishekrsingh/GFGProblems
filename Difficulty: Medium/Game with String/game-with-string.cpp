class Solution {
  public:
    int minValue(string& s, int k) {
        vector<int> freq(26, 0); // Frequency array for 26 lowercase letters

        // Count frequencies
        for (char ch : s) {
            freq[ch - 'a']++;
        }

        // Remove k characters greedily from the highest frequency char
        while (k--) {
            sort(freq.begin(), freq.end()); // Sort to bring max freq to end
            if (freq[25] == 0) {            // If all characters are removed
                break;
            }
            freq[25]--; // Remove one occurrence from highest freq char
        }

        int result = 0;
        for (int val : freq) {
            result += val * val; // Sum of squares of remaining frequencies
        }

        return result;
    }
};