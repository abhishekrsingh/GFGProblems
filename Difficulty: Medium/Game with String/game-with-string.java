class Solution {
    public int minValue(String s, int k) {
        // Step 1: Count frequency of each character and get maximum frequency
        int[] alphaFreq = new int[26];
        int maxi = 0;

        for (char ch : s.toCharArray()) {
            alphaFreq[ch - 'a']++;
            maxi = Math.max(maxi, alphaFreq[ch - 'a']);
        }

        // Step 2: Build a bucket array where index = frequency and value = count of chars with that freq
        int[] freq = new int[maxi + 1];
        for (int i = 0; i < 26; i++) {
            if (alphaFreq[i] > 0) {
                freq[alphaFreq[i]]++;
            }
        }

        int maxFreq = maxi;

        // Step 3: Reduce highest frequencies greedily
        while (k > 0 && maxFreq > 0) {
            int countAtMax = freq[maxFreq];

            if (countAtMax <= k) {
                k -= countAtMax;
                freq[maxFreq - 1] += countAtMax;
                freq[maxFreq]      = 0;
                maxFreq--;
            } else {
                freq[maxFreq]     -= k;
                freq[maxFreq - 1] += k;
                k = 0;
            }
        }

        // Step 4: Calculate sum of squares of remaining frequencies
        int result = 0;
        for (int i = 1; i <= maxi; i++) {
            result += i * i * freq[i];
        }

        return result;
    }
}