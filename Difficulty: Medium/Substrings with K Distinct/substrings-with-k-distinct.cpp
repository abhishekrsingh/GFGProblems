class Solution {
  public:
    int countAtMostK(string& s, int k) {
        int n           = s.length(); // Length of the string
        int mp[26]      = { 0 };      // Frequency array for lowercase letters
        int i           = 0;          // Left pointer of sliding window
        int j           = 0;          // Right pointer of sliding window
        int result      = 0;          // Count of substrings
        int distinctCnt = 0;          // Number of distinct characters in current window

        while (j < n) {
            // If the character is new to the window
            if (mp[s[j] - 'a'] == 0) {
                distinctCnt++;
            }
            mp[s[j] - 'a']++; // Add current character to the window

            // Shrink the window until we have at most k distinct characters
            while (distinctCnt > k) {
                mp[s[i] - 'a']--;  // Remove from left
                if (mp[s[i] - 'a'] == 0) {
                    distinctCnt--; // A distinct character is completely removed
                }
                i++;
            }

            result += j - i + 1; // All substrings ending at j with at most k distinct
            j++;
        }
        return result;
    }
    int countSubstr(string& s, int k) {
        // Count substrings with exactly k distinct characters
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }
};