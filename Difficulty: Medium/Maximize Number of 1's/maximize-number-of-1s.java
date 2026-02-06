class Solution {
    public int maxOnes(int arr[], int k) {
        int c = 0,i = 0,j = 0,ans = 0;
        while(j<arr.length){
            while(arr[j]==0 && c+1>k){
                if(arr[i]==0) c--;
                i++;
            }
            if(arr[j]==0) c++;
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}