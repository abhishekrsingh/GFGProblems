
class Solution {
    public int maximumAmount(int arr[]) {
        
        int dp[][]=new int[arr.length][arr.length];
        
        for(int[] i:dp) Arrays.fill(i,-1);
        return recurse(0,arr.length-1,arr,dp,0);
        
    }
    
    int recurse(int i,int j,int arr[],int dp[][],int count){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int a=0,b=0;
        if(count%2==0){
         
         a=recurse(i+1,j,arr,dp,count+1)+arr[i];
         b=recurse(i,j-1,arr,dp,count+1)+arr[j];
         dp[i][j]=Math.max(a,b);
         
        }
        else{
            
         a=recurse(i+1,j,arr,dp,count+1);
         b=recurse(i,j-1,arr,dp,count+1);  
         dp[i][j]=Math.min(a,b);
           
        }
        return dp[i][j];
    }
}
