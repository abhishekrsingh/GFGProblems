class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        int k=pat.length()-1;
        int l=tar.length()-1;
        while(k>=0&&l>=0){
            if(pat.charAt(k)==tar.charAt(l)){
                k--;
                l--;
            }
            else{
                k-=2;
            }
            
        }
        return l<0;
    }
}
