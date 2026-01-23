class Solution {
  public:
    void find(vector<int>&arr, vector<int>&ngr){
        int n=arr.size();
        stack<int>st;
        for(int i=0; i<n; i++){
            while(!st.empty() && arr[i]>=arr[st.top()]){
                ngr[st.top()]+=i-st.top();
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            ngr[st.top()]+=n-st.top();
            st.pop();
        }
    }
    int maxPeople(vector<int> &arr) {
        int n=arr.size();
        vector<int>ngr(n,0);
        find(arr,ngr);
        reverse(arr.begin(),arr.end());
        reverse(ngr.begin(),ngr.end());
        find(arr,ngr);
        int ans=0;
        for(auto it:ngr){
            ans=max(ans,it-1);
        }
        return ans;
    }
};