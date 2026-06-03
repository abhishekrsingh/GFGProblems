
class Solution {
  public:
    char nonRepeatingChar(string &s) {
        //  code here
        int n = s.length();
        vector<int> countChar(26, 0);
        for(auto &ch: s) countChar[ch - 'a']++;
        for(int i = 0; i < n; i++) {
            char current_char = s[i];
            
            // Check the frequency of this specific character in our bucket
            if(countChar[current_char - 'a'] == 1) {
                return current_char; // Found it! Return it immediately
            }
        }
        return '$';
    }
    // char nonRepeatingChar(string &s) {
    //     //  code here
    //     int n = s.length();
    //     unordered_map<char, int> charCount;
    //     for(auto &ch: s) charCount[ch]++;
    //     for(auto& [ch, count]: charCount)
    //     {
    //         if(count == 1) return ch;
    //     }
    //     return '$';
    // }
};