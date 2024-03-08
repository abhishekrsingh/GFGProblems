//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        String resultedString = "";
        StringBuilder str = new StringBuilder(s);
        
        for(int i=0;i<n;i++){
            String temp = "";
            for(int j=i;j<n;j++){
                temp=temp+str.charAt(j);
                if(str.indexOf(temp,j+1) != -1){
                    if(resultedString.length() < temp.length()) resultedString = temp;
                   // System.out.println(temp);
                }
                else break;
                }
        }
        return resultedString==""?"-1":resultedString;
    }
};