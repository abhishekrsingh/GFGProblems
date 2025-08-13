class Solution {
    public ArrayList<Integer> minMaxCandy(int[] arr, int k) {
        int min=0,max=0;
        Arrays.sort(arr);
        int len=arr.length;
        int len1=len;
        for(int i=0;i<arr.length;i++)
        {
            min=min+arr[i];
            max=max+arr[len1-1];
            len=len-k-1;
            len1--;
            if(len<=0)
            break;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(min);
        ans.add(max);
        return ans;
        
    }
}
