class Solution {
  public:
    bool wifiRange(string &s, int x) {
        // code here
        int prev=INT_MIN;
        int count=0;
        int n=s.size();
        bool danger=false;
        for(int i=0;i<n;i++){
            if(s[i]=='1'){
                count=0;
                danger=false;
                prev=i;
            }
            else{
                if(prev<i-x){
                    count++;
                    danger=true;
                }
                if(count>x)return false;
            }
        }
        if(danger)return false;
        return true;
    }
};