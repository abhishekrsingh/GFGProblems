class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        int i=0;
        int j=0;
        int k=0;
        
        int l1=a.length;
        int l2=b.length;
        int l3=c.length;
        
        
        while(i<l1 && j<l2 && k<l3)
        {
            if(a[i]==b[j] && b[j]==c[k])
            {
                if(list.size()==0)list.add(a[i]);
                else if(list.get(list.size()-1) != a[i])list.add(a[i]);
                i++;
                j++;
                k++;
            }
            else if(a[i]<b[j] || a[i]<c[k])i++;
            else if(b[j]<c[k] || b[j]<a[i])j++;
            else if(c[k]<b[j] || c[k]<a[i])k++;
        }
        return list;
    }
}