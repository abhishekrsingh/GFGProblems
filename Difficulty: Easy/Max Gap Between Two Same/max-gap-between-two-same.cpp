class Solution {
  public:
    int maxCharGap(string &s) {
        // code here
        int n = s.length();
        int max_dist = -1;
        
        vector<int> seen(26, -1);
        for(int i=0; i<n; i++){
            int idx = s[i] - 'a';
            
            if(seen[idx] != -1)
            {
                int curr_dist = i - seen[idx] - 1;
                max_dist = max(max_dist, curr_dist);
            }else{
                seen[idx] = i;
            }
        }
        
        return max_dist;
    }
};