class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        for(int i=0;i<k;i++)
        {
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            else
                hm.put(arr[i],1);
                
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(hm.size());
        for(int i=k; i<arr.length; i++)
        {
            if(hm.containsKey(arr[i-k]))
            {
                if(hm.get(arr[i-k])>1)
                    hm.put(arr[i-k],hm.get(arr[i-k])-1);
                else
                    hm.remove(arr[i-k]);
            }
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            else
                hm.put(arr[i],1);
                
            //System.out.print(". "+hm);
            ans.add(hm.size());
            
        }
        return ans;
    }
}