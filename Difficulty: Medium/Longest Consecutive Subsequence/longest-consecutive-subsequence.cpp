class Solution {
  public:
    int longestConsecutive(vector<int>& arr) {
        // code here
        int n=arr.size();
        sort(arr.begin(),arr.end());
        int maxLen = 1;
        int currentLen = 1;
        for(int i=0; i<n-1; i++)
        {
            int diff = arr[i+1] - arr[i];
            if(diff == 1){
                currentLen++;
                maxLen = max(maxLen, currentLen);
            }else if(diff == 0){
                continue;
            }else{
                currentLen = 1;
            }
        }
        return maxLen;
    }
    
    //1 9 3 10 4 20 2 
    //1 2 3 4 9 10 20
};