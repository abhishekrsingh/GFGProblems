class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        LinkedHashSet<Integer> set=new LinkedHashSet<>();
        int index_a=0, index_b=0;
        while(index_a<a.length && index_b<b.length){
            if((a[index_a]==b[index_b]) && !set.contains(a[index_a])){
                set.add(a[index_a]);
            }else if(a[index_a]>b[index_b]){
                index_b++;
            }else{
                index_a++;
            }
        }
        return (new ArrayList<>(set));
    }
}