class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        int n=arr.length;
        long[] prefixSum=new long[n];
        prefixSum[0]=arr[0];
        for(int i=1;i<n;i++) {
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            long rangeSum=prefixSum[right];
            if(left>0){
                rangeSum-=prefixSum[left-1];
            }
            int count=(right-left+1);
            int avg=(int)(rangeSum/count);
            al.add(avg);
        }
        return al;
    }
}