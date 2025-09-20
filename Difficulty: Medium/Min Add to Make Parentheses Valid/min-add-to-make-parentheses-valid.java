class Solution {
    public int minParentheses(String s) {
        // code here
        int open = 0;
        int close = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                close++;
            }
        }
        return open + close;
    }
}
