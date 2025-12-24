class Solution {
    public:
    int pivot(vector<int>&arr){
        //int ans=0;
        int l=0;
        int h=arr.size()-1;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>arr[h]){
                l=m+1;
            }
            else h=m;
        }
        return l;
    }
    
    int countLessEqual(vector<int>& arr, int x) {
        // code here
        int piv = pivot(arr);

        int c1 = upper_bound(arr.begin(), arr.begin() + piv, x) - arr.begin();
        int c2 = upper_bound(arr.begin() + piv, arr.end(), x) - (arr.begin() + piv);

         return c1 + c2;
    }
};