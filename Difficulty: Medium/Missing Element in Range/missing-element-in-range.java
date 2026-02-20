class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        Set<Integer> s = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            s.add(arr[i]);
        }
        for(int i=low;i<=high;i++){
            if(!s.contains(i))ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}