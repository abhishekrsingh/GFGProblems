class Solution {
  public:
    void segregateElements(vector<int>& arr) {
        // code here
        vector<int> res;
        for(int x: arr) if(x >= 0)res.push_back(x);
        for(int x: arr) if(x < 0)res.push_back(x);
        arr = res;
    }
};