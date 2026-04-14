class Solution {
  public:
    string removeSpaces(string& s) {
        // code here
        string finalString = "";
        for(int i=0; i<s.length(); i++)
        {
            if(s[i] != ' ') finalString += s[i];
        }
        return finalString;
    }
};