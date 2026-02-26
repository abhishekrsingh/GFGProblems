class Solution {
  public:
    bool areIsomorphic(string str1, string str2)
    {
        // Your code here
        if (str1.length() != str2.length()) return false;

        unordered_map<char, char> mapping1;
        unordered_map<char, char> mapping2;
    
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1[i];
            char char2 = str2[i];
    
            if (mapping1.find(char1) == mapping1.end()) {
                mapping1[char1] = char2;
            } else if (mapping1[char1] != char2) {
                return false;
            }
    
            if (mapping2.find(char2) == mapping2.end()) {
                mapping2[char2] = char1;
            } else if (mapping2[char2] != char1) {
                return false;
            }
        }
    
        return true;
        
    }
};