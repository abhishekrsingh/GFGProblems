class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        int xor=0;
        for(int i=1;i<=n;i++) xor^=i;

        int removeNo=xor^n;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i!=removeNo) arr.add(i);
        }
        return arr;
    }
}
