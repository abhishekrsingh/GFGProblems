class Solution {
    public int findIndex(String s) {
        // code here
        int total_close = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                total_close++;
            }
        }
        return total_close;
    }
}