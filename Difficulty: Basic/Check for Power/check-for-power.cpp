class Solution {
  public:
    bool isPower(int x, int y) {
        if (x == 1) return y == 1;   // 1^k = 1 only
        if (y == 1) return true;     // x^0 = 1 for any x > 0
        while (y % x == 0) {
            y /= x;
        }
        return y == 1;
    }
};