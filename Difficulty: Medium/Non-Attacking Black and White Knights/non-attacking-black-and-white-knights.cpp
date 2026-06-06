class Solution {
  public:
    int numOfWays(int n, int m) {
        return n*m*((n*m)-9) + 12*(n+m) - 16;
    }
};