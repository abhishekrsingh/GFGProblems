class Solution {
public:
    vector<vector<vector<int>>> dp;
    int solve(int i,vector<int>& arr,int lastIdx1,int lastIdx2,int n){
        //take
        if(dp[i][lastIdx1][lastIdx2] != INT_MAX){
            return dp[i][lastIdx1][lastIdx2];
        }
        if(i >= n){
            return dp[i][lastIdx1][lastIdx2] = 0;
        }
        if(lastIdx1 < n && lastIdx2 < n){
            if(arr[i] > arr[lastIdx1] && arr[i] < arr[lastIdx2]){
               int a = 1 + solve(i+1,arr,i,lastIdx2,n);
               int b = 1 + solve(i+1,arr,lastIdx1,i,n);
               int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n);
               return dp[i][lastIdx1][lastIdx2] = max(a,max(b,c));
            }
            if(arr[i] > arr[lastIdx1] && arr[i] >= arr[lastIdx2]){
               int a = 1 + solve(i+1,arr,i,lastIdx2,n);
               int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n);
               return dp[i][lastIdx1][lastIdx2] = max(a,c);
            }
            if(arr[i] <= arr[lastIdx1] && arr[i] < arr[lastIdx2]){
               int b = 1 + solve(i+1,arr,lastIdx1,i,n);
               int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n);
               return dp[i][lastIdx1][lastIdx2] = max(b,c);
            }
            else{
                return dp[i][lastIdx1][lastIdx2] = solve(i+1,arr,lastIdx1,lastIdx2,n);
            }
        }
        if(lastIdx1 < n && lastIdx2 == n){
            if(arr[i] > arr[lastIdx1]){
               int a = 1 + solve(i+1,arr,i,lastIdx2,n);
               int b = 1 + solve(i+1,arr,lastIdx1,i,n);
               int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n);
               return dp[i][lastIdx1][lastIdx2] = max(a,max(b,c));
            }
            else{
               int b = 1 + solve(i+1,arr,lastIdx1,i,n);
               int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n); 
               return dp[i][lastIdx1][lastIdx2] = max(b,c);
            }
        }
        if(lastIdx1 == n && lastIdx2 < n){
            if(arr[i] < arr[lastIdx2]){
               int a = 1 + solve(i+1,arr,lastIdx1,i,n);
               int b = 1 + solve(i+1,arr,i,lastIdx2,n);
               int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n);
               return dp[i][lastIdx1][lastIdx2] = max(a,max(b,c));
            }
            else{
               int b = 1 + solve(i+1,arr,i,lastIdx2,n);
               int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n); 
               return dp[i][lastIdx1][lastIdx2] = max(b,c);
            }
        }
        else{
            int a = 1 + solve(i+1,arr,i,lastIdx2,n);
            int b = 1 + solve(i+1,arr,lastIdx1,i,n);
            int c = 0 + solve(i+1,arr,lastIdx1,lastIdx2,n);
            return dp[i][lastIdx1][lastIdx2] = max(a,max(b,c));
        }
    }
    int minCount(vector<int>& arr) {
        //we should apply take/not take DP , i think.
        //that's okay , i guess.
        //understood acc. to situation.
        int n = arr.size();
        dp.assign(n+1,vector<vector<int>>(n+2,vector<int>(n+2,INT_MAX)));
        int i = 0;
        int lastIdx1 = n;
        int lastIdx2 = n;
        int x = solve(i,arr,lastIdx1,lastIdx2,n);
        return n-x;
    }
};