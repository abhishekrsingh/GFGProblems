class Solution {
  public:
    bool sameFreq(string& s) {
        vector<int> freq(26, 0);  // Count frequency of each character (a-z)

        for (char ch : s) {
            freq[ch - 'a']++;
        }

        int maxFreqValue   = INT_MIN;  // Track the maximum frequency
        int maxFreqCounter = 0;        // How many chars have that maximum
        int minFreqValue   = INT_MAX;  // Track the minimum frequency (among >0)
        int minFreqCounter = 0;        // How many chars have that minimum

        for (int f : freq) {
            if (f == 0) {
                continue;
            }

            if (f == maxFreqValue) {
                maxFreqCounter++;
            }
            if (f == minFreqValue) {
                minFreqCounter++;
            }
            if (f > maxFreqValue) {
                maxFreqValue = f; maxFreqCounter = 1;
            }
            if (f < minFreqValue) {
                minFreqValue = f; minFreqCounter = 1;
            }
        }

        // Case 1: all frequencies are already the same
        if (maxFreqValue == minFreqValue) {
            return true;
        }
        // Case A: two distinct freqs differ by 1, and the higher one occurs exactly once
        if ((maxFreqValue - minFreqValue) == 1 && maxFreqCounter == 1) {
            return true;
        }
        // Case B: one char has freq==1, and removing it leaves all remaining chars at the same freq
        if (minFreqValue == 1 && minFreqCounter == 1) {
            int nextMin = INT_MAX;
            for (int f : freq) {
                if (f > minFreqValue) {
                    nextMin = min(nextMin, f);
                }
            }
            if (nextMin == maxFreqValue) {
                return true;
            }
        }

        // Otherwise, can't equalize with a single removal
        return false;
    }
};