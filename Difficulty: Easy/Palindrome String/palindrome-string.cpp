class Solution {
  public:
    bool isPalindrome(string& s) {
        // code here
        int len = s.length();
        int i=0, j=len-1;
        while(i<j)
        {
            if(s[i] != s[j]) return false;
            i++;
            j--;
        }
        return true;
    }
};