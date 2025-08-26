class Solution {
  public:
    bool isSubSeq(string s1, string s2) {
        int m = s1.length();
        int n = s2.length();
        
        int i = 0, j = 0;
        
        while (i < m && j < n) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i >= m) return true;
        }
        
        return (i >= m);
    }
};