class Solution {
  public:
    bool checkRedundancy(string &s) {
        // code here
        stack<char> st;
    
        for (char ch : s) {
            if (ch == ')') {
                bool hasOperator = false;
                // Pop until '(' is found
                while (!st.empty() && st.top() != '(') {
                    char top = st.top();
                    if (top == '+' || top == '-' || top == '*' || top == '/')
                        hasOperator = true;
                    st.pop();
                }
                
                // Remove '(' from stack
                if (!st.empty())
                    st.pop();
                
                // If no operator found, redundant parentheses
                if (!hasOperator)
                    return true;
            } else {
                st.push(ch);
            }
        }
        
        return false;
    }
};
