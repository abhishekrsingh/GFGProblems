class Solution {
  public:
    bool isPossible(vector<int>& arr, int k) {
        int n=arr.size();
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<>>pq;
        pq.push({arr[0],1});
        int i=1;
        while(i<n&&!pq.empty()){
            if(arr[i]==pq.top().first+1){
                pq.push({arr[i],pq.top().second+1});
                pq.pop();
            }else if(pq.top().first==arr[i]){
                pq.push({arr[i],1});
            }else if(arr[i]>pq.top().first+1){
                //  cout<<pq.top().second<<" ";
                if(pq.top().second<k) return false;
                else{
                  pq.pop();
                  if(pq.empty())pq.push({arr[i],1});
                  else continue;
                } 
            }
            i++;
        }
        while(!pq.empty()){
            // cout<<pq.top().second<<" ";
            if(pq.top().second<k) return false;
            pq.pop();
        }
        return true;
    }
};
