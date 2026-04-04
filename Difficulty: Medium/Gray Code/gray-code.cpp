class Solution {
  public:
    vector<string> graycode(int n) {
        // code here
        const int size=1<<n;
        vector<string> result(size,string(n,'0'));
        for(int i=1;i<size;i++){
            int gray=i^(i>>1);
            string& s=result[i];
            for(int g=gray,j=n-1;g;g>>=1,j-- ){
                if(g&1) s[j]='1';
            }
        }
        return result;
    }
};