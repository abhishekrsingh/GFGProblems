class Solution {
    public boolean wifiRange(String s, int x) {
        int size = s.length();
        
        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '0') {
                int low = i;
                
                while(i+1 < size && s.charAt(i+1) == '0') {
                    i++;
                }
                
                // If string is all '0's or starts or ends at zero or then range is through one side of '1'
                // If 0 is somewhere in between then both side of '1's will cover the range
                if( (low == 0 && i == size-1) || (low == 0 && i - low + 1 > x) || (i == size-1 && i - low + 1 > x) || (i - low + 1 > 2*x) ) {
                    return false;
                }
            }
        }
        
        return true;
    }
}