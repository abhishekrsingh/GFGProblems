
class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
        int n=arr.length;
        int[] start=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++)
        {
            start[i]=arr[i][0];
            end[i]=arr[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0,j=0,curr=0,ans=0;
        while(i<n && j<n)
        {
            if(start[i]<=end[j])
            {
                curr++;
                ans=Math.max(curr,ans);
                i++;
            }
            else
            {
                curr--;
                j++;
            }
        }
        return ans;
    }
}
