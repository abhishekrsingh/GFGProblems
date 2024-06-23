//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        StringBuilder number = new StringBuilder();
        long largest = -1;

        for (int i = 0; i <= sentence.length(); i++) {
            char ch = i < sentence.length() ? sentence.charAt(i) : ' ';
            
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    String numStr = number.toString();
                    if (!numStr.contains("9")) {
                        long num = Long.parseLong(numStr);
                        if (num > largest) {
                            largest = num;
                        }
                    }
                    number.setLength(0); // Reset the StringBuilder for the next number
                }
            }
        }

        return largest;
    }
}