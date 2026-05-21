class Solution {
  public:
    bool isBitSet(int n) {
        // code here
        if (n <= 0)
            return false;

        int x = n + 1;
    
        // Check if x is power of 2
        return (x & (x - 1)) == 0;
    }
};