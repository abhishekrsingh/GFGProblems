class Solution {
  public:
    void pushZerosToEnd(vector<int>& arr) {
        // code here
        int n=arr.size();
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i])arr[count++]=arr[i];
        }
        while(count<n)arr[count++]=0;
    }
};