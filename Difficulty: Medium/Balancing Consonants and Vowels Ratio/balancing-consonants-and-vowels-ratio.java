class Solution {
    public int countBalanced(String[] arr) {
        // code here
        int n=arr.length;
        int v[]=new int[n],c[]=new int[n];
        int temp[]=count(arr[0]);
        v[0]=temp[1];c[0]=temp[0];
        for(int i=1;i<n;i++){
            int curr[]=count(arr[i]);
            v[i]=v[i-1]+curr[1];
            c[i]=c[i-1]+curr[0];
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        for(int i=0;i<n;i++){
            int diff=c[i]-v[i];
            int curr=map.getOrDefault(diff,0);
            ans+=curr;
            map.put(diff,curr+1);
        }
        return ans;
        
    }
    public int[] count(String s){
        int v=0,c=0;
        for(char ch: s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                v++;
            }
            else{
                c++;
            }
        }
        return new int[]{c,v};
    }
}