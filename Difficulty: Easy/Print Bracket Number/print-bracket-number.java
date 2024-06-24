//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> nums = new ArrayList<>();
        Stack<Integer> ranks = new Stack<>();
        int rank = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                ++rank;
                nums.add(rank);
                ranks.push(rank);
            }
            if(ch == ')'){
                nums.add(ranks.pop());
            }
        }
        return nums;
    }
};