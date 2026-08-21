class Solution {
  public:
    int transform(string &s1, string &s2) {
        int n = s1.length();
        if (n != s2.length()) return -1;
    
        // Feasibility check: must be anagrams
        int freq[256] = {0};
        for (char c : s1) freq[c]++;
        for (char c : s2) freq[c]--;
        for (int f : freq) if (f != 0) return -1;
    
        // Two-pointer from the back: find longest suffix of s2
        // that appears as a subsequence in s1 (order preserved).
        int i = n - 1, j = n - 1, matched = 0;
        while (i >= 0 && j >= 0) {
            if (s1[i] == s2[j]) {
                matched++;   // this char stays in place, no move needed
                j--;
            }
            i--;             // always move left pointer of s1
        }
    
        // Characters not matched must each be moved once
        return n - matched;
    }
};
