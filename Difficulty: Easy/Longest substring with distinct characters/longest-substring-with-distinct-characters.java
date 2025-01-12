//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int longestUniqueSubstr(String S) 
    {
        HashSet <Character> hs = new HashSet <> ();
        int max = 0;
        int start = 0;
        
        for(int end = 0; end < S.length(); end++) 
        {
            char ch = S.charAt(end);
            
            while(hs.contains(ch)) 
            {
                hs.remove(S.charAt(start));
                start++;
            }
            
            hs.add(ch);
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}