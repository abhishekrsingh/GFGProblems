//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    Stack<Integer> stack = new Stack<>();
    public int evaluate(String[] arr) {
        for(String token: arr){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculation(a,b,token));
            }
            else
            {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
        
    }
    
    public static boolean isOperator(String token){
        return token.equals("+")|| token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    
    public static int calculation(int a , int b , String operator){
        switch(operator){
            case "+" : return a + b ;
            case "-" : return a- b;
            case "*" : return a * b;
            case "/" : return a / b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends