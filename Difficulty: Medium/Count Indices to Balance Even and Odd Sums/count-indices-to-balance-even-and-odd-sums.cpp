class Solution {
  public:
    int cntWays(vector<int>& arr) {
        int n=arr.size();
        int total=accumulate(arr.begin(),arr.end(),0);
        int ans=0;
        vector<int>odd(n),even(n);
        even[0]=arr[0];
        odd[0]=0;
        for(int i=1;i<n;i++){
            if(i&1){
                even[i]=even[i-1];
                odd[i]=odd[i-1]+arr[i];
            }
            else{
                even[i]=even[i-1]+arr[i];
                odd[i]=odd[i-1];
            }
        }
        
        for(int i=0;i<n;i++){
            int esum=even[i];
            int osum=odd[i];
            if(i&1){
                osum-=arr[i];
                osum+=(even[n-1]-even[i]);
                esum+=(odd[n-1]-odd[i]);
                if(esum==osum)ans++;
            }
            else{
                esum-=arr[i];
                osum+=(even[n-1]-even[i]);
                esum+=(odd[n-1]-odd[i]);
                if(esum==osum)ans++;
            }
        }
        
        
        return ans;
        
    }
};