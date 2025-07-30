class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int startidx=-1;
        int endidx=-1;
        Set<Character>st=new HashSet<>();
        char[]arr=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            st.add(arr[i]);
        }
        
       for (Character element : st) {
            int sum=0;
            startidx=s.indexOf(element);
            endidx=s.lastIndexOf(element);
                
            for(int i=startidx+1;i<endidx;i++)
            {
                sum+=s.charAt(i);
            }
            if(sum>0){
            ans.add(sum);
            }
        }
        return ans;
    }
}