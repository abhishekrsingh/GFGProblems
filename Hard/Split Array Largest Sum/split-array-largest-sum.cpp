//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    bool isPossible(int arr[],int N,int mid,int K){
        int count=1,sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
            if(sum>mid){
                count++;
                sum=arr[i];
            }
        }
        return K>=count;
    }
    int splitArray(int arr[] ,int N, int K) {
        // code here
        int low=INT_MIN,high=0,mid,ans=INT_MAX;
        for(int i=0;i<N;i++){
            low=max(arr[i],low);
            high+=arr[i];
        }
        while(low<=high){
            mid=(low+high)/2;
            if(isPossible(arr,N,mid,K)){
                ans=min(ans,mid);
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        
        cin>>N>>K;
        int arr[N];
        
        for(int i=0 ; i<N ; i++)
            cin>>arr[i];

        Solution ob;
        cout<<ob.splitArray(arr,N,K);
        cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends