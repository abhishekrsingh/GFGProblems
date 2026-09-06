class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        Map<Integer,Integer> m=new HashMap<>();
        int ans=0;
        for(int i:arr){
            int c=1;
            if(m.containsKey(i-1)) c=Math.max(c,m.get(i-1)+1);
            if(m.containsKey(i+1)) c=Math.max(c,m.get(i+1)+1);
            m.put(i,c);
            ans=Math.max(ans,c);
        }
        return ans;
    }
}
