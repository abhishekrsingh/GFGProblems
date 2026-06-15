class Solution {
  public:
    int longestUniqueSubstr(string &s) {
        // code here
        int n = s.length();
        int res = 0; // Yeh hamara maximum length store karega
    
        // Outer loop: Har ek character ko substring ka 'start' point maante hain
        for (int i = 0; i < n; i++) {
            
            // Visited array check karne ke liye ki koi char is substring mein repeat toh nahi hua
            // Lowercase English alphabets ke liye size 26 kaafi hai
            vector<bool> visited(26, false);
    
            // Inner loop: 'i' se shuru karke aage tak substring extend karte hain
            for (int j = i; j < n; j++) {
                
                // Character ka index nikalne ke liye (e.g., 'a' - 'a' = 0, 'b' - 'a' = 1)
                int charIndex = s[j] - 'a';
    
                // Agar character pehle se visited hai, matlab repeat ho gaya!
                // Toh is loop ko break kar do, aage check karne ki zaroorat nahi hai.
                if (visited[charIndex] == true) {
                    break;
                }
    
                // Agar naya character hai, toh use visited mark karo
                visited[charIndex] = true;
    
                // Maximum length ko update karo
                res = max(res, j - i + 1);
            }
        }
        return res;
    }
};
