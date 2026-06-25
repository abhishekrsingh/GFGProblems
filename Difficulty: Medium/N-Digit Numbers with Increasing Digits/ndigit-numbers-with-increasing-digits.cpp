class Solution {
  public:
    void solve(int total_digits , int curr_digit, int num , vector<int>&ans){
        if(total_digits==0){
            ans.push_back(num);
            return;
        }
        for(int i = curr_digit+1;i<=9;i++)
        solve(total_digits-1,i,num*10+i,ans);
    
    }
    vector<int> increasingNumbers(int n) {
        vector<int> ans;
        if(n==1){
            for(int i=0;i<=9;i++) ans.push_back(i);
        }
        else if(n>9) return {};
        else{
        for(int i=1;i<9;i++){
           solve(n-1,i,i,ans); 
        }
        }
        return ans;
    }
};