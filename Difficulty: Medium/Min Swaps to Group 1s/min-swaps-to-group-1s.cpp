class Solution {
  public:
    int minSwaps(vector<int>& arr) {
        // code here
        int n=arr.size(), ones=0;
        for(int x:arr) if(x) ones++;
        if(ones==0) return -1;
        int swaps=1e9, left=0, right=0, zeros=0;
        while(right<n){
            if(arr[right]==0) zeros++;
            if(right-left+1==ones){
                swaps=min(swaps,zeros);
                if(arr[left]==0) zeros--;
                left++;
            }
            right++;
        }
        return swaps;
    }
};