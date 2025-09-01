class Solution {
  public:
    int sumOfModes(vector<int>& arr, int k) {
        // code here
        unordered_map<int,int>mp;
        set<pair<int,int>>st;
        int n=arr.size();
        for(int i=0;i<k;i++){
            mp[arr[i]]++;
        }
        for(auto it:mp){
            st.insert({it.second, -it.first});
        }
        int sum=-st.rbegin()->second;
        for(int i=k;i<n;i++){
            int out=arr[i-k], in=arr[i];
            st.erase({mp[out], -out});
            mp[out]--;
            if(mp[out]>0){
                st.insert({mp[out], -out});
            }
            if(mp[in]>0){
                st.erase({mp[in],-in});
            }
            mp[in]++;
            st.insert({mp[in],-in});
            
            sum+=-st.rbegin()->second;
            
            
        }
        return sum;
    }
};