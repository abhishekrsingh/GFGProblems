class Solution {
    public int countPS(String s) {
        // code here
        int[] count = new int[1];
        
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            //even-length palin check
            checkPalin(s,i,i+1,count);
            
            //odd-length palin check
            checkPalin(s,i,i,count);
        }
        return count[0];
    }
    private void checkPalin(String s,
    int i,int j,int[] count)
    {
        while(i>=0 && j<s.length() &&
        s.charAt(i)==s.charAt(j))
        {
            if(j-i+1>=2)
            count[0]++;
            
            i--;
            j++;
        }
        
    }
}