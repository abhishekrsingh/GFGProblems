class Solution {
  public:
    void rotate(vector<int> &arr) {
        // code here
        vector<int> temp(arr.begin(), arr.end() - 1);
        arr[0] = arr.back();
        for(int i=0; i<temp.size(); i++){
            arr[i+1] = temp[i];
        }
    }
};