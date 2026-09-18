class Solution {
  public:
    vector<int> nextGreatest(vector<int> arr) {
        // code here
        int n = arr.size();
        vector<int> res(n);
        int mx = -1;
        for(int i=n-1; i>=0; i--){
            res[i] = mx;
            mx = max(mx, arr[i]);
        }
        return res;
    }
    
    
    // vector<int> nextGreatest(vector<int> arr) {
    //     // code here
    //     int n = arr.size();
    //     vector<int> res(n);
    //     for(int i=0; i<n; i++){
    //         int mx = -1;
    //         for(int j=i+1; j<n; j++)
    //             mx = max(mx, arr[j]);
    //         res[i] = mx;
    //     }
    //     return res;
    // }
};