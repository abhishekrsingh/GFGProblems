class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        int l=chairs.length;
        int r=0;
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        
        for(int i=0;i<l;i++){
            if(chairs[i]!=passengers[i]){
                if(chairs[i]>passengers[i]){
                    r+=chairs[i]-passengers[i];
                }else{
                    r+=passengers[i]-chairs[i];
                }
            }
        }
        return r;
    }
}
