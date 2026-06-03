class Solution {
  public:
    int repeatedCharacter(string& s) {
        // code here
        int n = s.length();
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(s[i] == s[j]) return i;
            }
        }
        return -1;
    }
};