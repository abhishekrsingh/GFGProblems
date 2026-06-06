class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
        
        Stack<Character> st = new Stack<>();
        
        int i = 0;
        int n = s.length();
        
        if((n & (n - 1)) == 0){
            k /= 2;
        }else{
            k *= 2;
        }
        while(i < n){
            char ch = s.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
            i++;
        }
        
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        sb.reverse();
        if(sb.length() == 0){
            return "-1";
        }
        return sb.toString();
    }
}