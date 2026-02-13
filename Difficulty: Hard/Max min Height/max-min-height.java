class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int min=0;
        int max=Integer.MAX_VALUE;
        int ans=0;
        while(min<=max)
        {
            int mid=min+(max-min)/2;
            if(isPossible(arr,k,w,mid))
            {
                ans=mid;
                min=mid+1;
            }
            else{
                max=mid-1;
            }
        }
        return ans;
        
    }
    
    public boolean isPossible(int[]arr,int k,int w,int h)
    {
        int n=arr.length;
        int []prefix= new int[n+1];
        int days=0;
        
        for(int i=0;i<n;i++)
        {
            if(i>0)
            {
                prefix[i]+=prefix[i-1];
            }
            if(prefix[i]+arr[i]<h)
            {
                int req=h-(prefix[i]+arr[i]);
                prefix[i]+=req;
                days+=req;
                if(days>k)
        return false;
                if(i+w<=n)
                {
                    prefix[i+w]-=req;
                }
            }
        }
        
        
        return true;
    }
}