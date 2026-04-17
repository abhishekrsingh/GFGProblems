class Solution {
  public:
    bool canFormPalindrome(string &s) {
        // code here
        int mask = 0;

        // toggle bits
        for (int i = 0; s[i]; i++) {
            int bit = s[i] - 'a';
            mask ^= (1 << bit);
        }
    
        // check at most one bit set
        return (mask == 0) || (mask & (mask - 1)) == 0;
    }
};