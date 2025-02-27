//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;
    
    public Solution() {
        st = new Stack<>();
    }

    public void push(int x) {
        // code here
        if (x <= min) {
            st.push(min);
            min = x;
        }
        
        st.push(x);
    }

    public void pop() {
        if (st.isEmpty()) return;
        int top = st.pop();
        if (top == min) min = st.pop();
    }

    public int peek() {
        if (st.isEmpty()) return -1;
        return st.peek();
    }

    public int getMin() {
        if (st.isEmpty()) return -1;
        return min;
    }
}