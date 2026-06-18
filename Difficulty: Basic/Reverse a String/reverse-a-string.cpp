// User function Template for C++
class Solution {
  public:
    string reverseString(string& s) {
        // code here
        int left = 0, right = s.length() - 1;
        while(left < right)
        {
            swap(s[left++], s[right--]);
        }
        return s;
    }
};
