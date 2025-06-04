// User function Template for Java

class Solution {
    int countAtMostK(String s, int k) {
        int n = s.length();                 // Length of the string
        int[] freq = new int[26];           // Frequency array for 'a' to 'z'
        int i = 0, j = 0;                   // Two pointers
        int result      = 0;                // Count of substrings
        int distinctCnt = 0;                // Number of distinct characters

        while (j < n) {
            if (freq[s.charAt(j) - 'a'] == 0) {
                distinctCnt++;              // New distinct character
            }
            freq[s.charAt(j) - 'a']++;      // Add character to the window

            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;  // Shrink from the left
                if (freq[s.charAt(i) - 'a'] == 0) {
                    distinctCnt--;          // A distinct character is completely removed
                }
                i++;
            }

            result += j - i + 1;            // Valid substrings ending at j
            j++;
        }

        return result;
    }
    int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1); // Exactly K distinct substrings
    }
}