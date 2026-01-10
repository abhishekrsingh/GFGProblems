class Solution {
  public:
    int count(string &s, int k) {
        int n = s.length();
        int ans = 0;
        
        // use sliding window technique
        vector<int> freq(26, 0);
        int distinctCnt = 0;
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            
            // expand window and add character
            freq[s[j] - 'a']++;
            if (freq[s[j] - 'a'] == 1) distinctCnt++;
            
            // shrink window if distinct characters exceed k
            while (distinctCnt > k) {
                freq[s[i] - 'a']--;
                if (freq[s[i] - 'a'] == 0) distinctCnt--;
                i++;
            }
            
            // add number of valid substrings ending at j
            ans += j - i + 1;
        }
        
        return ans;
    }
    
    // function to find the number of substrings
    // with exactly k Distinct characters.
    int countSubstr(string &s, int k) {
        int n = s.length();
        int ans = 0;
        
        // subtract substrings with at most 
        // k-1 distinct characters from substrings
        // with at most k distinct characters
        ans = count(s, k) - count(s, k-1);
        
        return ans;
    }
};