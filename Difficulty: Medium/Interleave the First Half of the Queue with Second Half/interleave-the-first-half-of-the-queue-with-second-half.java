class Solution {
    public void rearrangeQueue(Queue<Integer> q) 
    {
        // code here
        int l= q.size();
        int mid=l/2;
        int x=0, y= 0;
        ArrayList<Integer> arr1= new ArrayList<>();
        ArrayList<Integer> arr2= new ArrayList<>();
        
        for(int i=0;i<mid;i++)
            arr1.add(q.poll());
        
        for(int i=mid;i<l;i++)
            arr2.add(q.poll());
            
        
        
        while(x<mid && y<l-mid)
        {
            q.add(arr1.get(x++));
            q.add(arr2.get(y++));
        }
        
        while(x<mid)
        {
            q.add(arr1.get(x++));
        }
        
        while(y<l-mid)
        {
            q.add(arr2.get(y++));
        }
    }
}
