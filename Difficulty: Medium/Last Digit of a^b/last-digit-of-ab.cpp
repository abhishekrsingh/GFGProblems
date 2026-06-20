class Solution {
  public:
    int getLastDigit(string& a, string& b) {
        if (b == "0") return 1;
    
        int lastDigit = a.back() - '0';
    
        int exp = 0;
        int len = b.size();
    
        if (len >= 2)
            exp = (b[len - 2] - '0') * 10 + (b[len - 1] - '0');
        else
            exp = b[len - 1] - '0';
    
        exp %= 4;
        if (exp == 0) exp = 4;
    
        int ans = 1;
        for (int i = 0; i < exp; i++)
            ans = (ans * lastDigit) % 10;
    
        return ans;
    }
};