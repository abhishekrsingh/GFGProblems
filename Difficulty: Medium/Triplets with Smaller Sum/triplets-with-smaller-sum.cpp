class Solution {
  public:
    int countTriplets(int sum, vector<int>& arr) {
        // code here
        int n = arr.size();
        sort(arr.begin(), arr.end());
        int result = 0;
        for(int i=0; i<n-2; i++)
        {
            int j = i+1, k = n-1;
            while(j<k)
            {
                if(arr[i]+arr[j]+arr[k] >= sum)
                    k--;
                else{
                    result += (k-j);
                    j++;
                }
            }
        }
        return result;
    }
};