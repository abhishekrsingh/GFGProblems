class Solution {
  public:
    int maxWater(vector<int> &arr) {
        // code here
        int n = arr.size();
        int maxWater = 0;
        int lp = 0, rp = n-1;
        int max_water = 0;
        while(lp<rp)
        {
            int w = rp - lp;
            int h = min(arr[rp], arr[lp]);
            int container = w * h;
            maxWater = max(maxWater, container);
            arr[lp] < arr[rp] ? lp++ : rp--;
        }
        return maxWater;
    }
};