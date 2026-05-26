class Solution {
  public:
    int minToggle(vector<int>& arr) {

        int zerosRight = 0;
    
        // Count total zeros
        for (int x : arr) {
            if (x == 0)
                zerosRight++;
        }
    
        int onesLeft = 0;
        int ans = zerosRight;
    
        // Move partition
        for (int x : arr) {
    
            if (x == 1)
                onesLeft++;
            else
                zerosRight--;
    
            ans = min(ans, onesLeft + zerosRight);
        }
    
        return ans;
    }
};