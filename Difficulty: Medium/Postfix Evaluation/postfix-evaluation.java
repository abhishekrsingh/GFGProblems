class Solution {
    static int floorDiv(int a, int b) {
        if (a * b < 0 && a % b != 0)
            return (a / b) - 1;
        return a / b;
    }
    
    public static int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();

        for (String token : arr) {
          
            // If it's an operand (number), push it onto the stack
            if (Character.isDigit(token.charAt(0)) || 
                (token.length() > 1 && token.charAt(0) == '-')) {
                st.push(Integer.parseInt(token));
            } 
        
            // Otherwise, it must be an operator
            else {
                int val1 = st.pop();
                int val2 = st.pop();

                if (token.equals("+")) st.push(val2 + val1);
                else if (token.equals("-")) st.push(val2 - val1);
                else if (token.equals("*")) st.push(val2 * val1);
                else if (token.equals("/")) st.push(floorDiv(val2, val1));
                else if (token.equals("^")) st.push((int)Math.pow(val2, val1));
            }
        }
        return st.pop();
    }
}