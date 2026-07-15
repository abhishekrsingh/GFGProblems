class Solution {
  public:
    int bitonic(vector<int> &arr) {
        int cnt = 1;
        int maxi = 1;
        int k = -1;
        for(int i = 1;i<arr.size();i++){
            if(arr[i] >= arr[i-1]){
                k = i;
                break;
            }
        }
        if(k == -1){
            return arr.size();
        }
        int kcnt = 0;
        bool bl = false;
        for(int i = k;i<arr.size();i++){
            if(bl){
              if(arr[i] <= arr[i-1]){
                  cnt++;
                  if(arr[i] == arr[i-1]){
                     kcnt++;
                  }
                  if(arr[i] != arr[i-1]){
                     kcnt = 0;
                  }
              }
              else{
                  maxi = max(maxi,cnt);
                  bl = false;
                  cnt = kcnt + 2;
                  if(kcnt == 0){
                     cnt = 2;
                  }
                  kcnt = 0;
              } 
            }
            else if(!bl){
               if(arr[i] >= arr[i-1]){
                  cnt++;
               }
               else{
                  bl = true;
                  cnt++;
               }
            }
        }
        maxi = max(maxi,cnt);
        maxi = max(maxi,k);
        return maxi;
    }
};