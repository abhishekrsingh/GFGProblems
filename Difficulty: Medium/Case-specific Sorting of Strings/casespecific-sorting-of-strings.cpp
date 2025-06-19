class Solution {
  public:
    string caseSort(string& s) {
        int n = s.size();

        int lower[26] = { 0 };
        int upper[26] = { 0 };

        // 1) Count frequencies
        for (char ch : s) {
            if (islower(ch)) {
                lower[ch - 'a']++;
            } else {
                upper[ch - 'A']++;
            }
        }

        // 2) Reconstruct result by consuming counts
        string result = s;
        int    l      = 0; // index for lowercase freq array
        int    u      = 0; // index for uppercase freq array

        for (int i = 0; i < n; i++) {
            if (islower(s[i])) {
                while (lower[l] == 0) {
                    l++;
                }
                result[i] = 'a' + l;
                lower[l]--;
            } else {
                while (upper[u] == 0) {
                    u++;
                }
                result[i] = 'A' + u;
                upper[u]--;
            }
        }

        return result;
    }
};