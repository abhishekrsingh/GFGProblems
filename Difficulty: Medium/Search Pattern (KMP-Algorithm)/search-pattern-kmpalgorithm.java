//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static void constructLps(String pat, int[] lps) {
        
        // len stores the length of longest prefix which 
        // is also a suffix for the previous index
        int len = 0;

        // lps[0] is always 0
        lps[0] = 0;

        int i = 1;
        while (i < pat.length()) {
            
            // If characters match, increment the size of lps
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            
            // If there is a mismatch
            else {
                if (len != 0) {
                    
                    // Update len to the previous lps value 
                    // to avoid redundant comparisons
                    len = lps[len - 1];
                } 
                else {
                    
                    // If no matching prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();

        constructLps(pat, lps);

        // Pointers i and j, for traversing 
        // the text and pattern
        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched 
                // store the start index in result
                if (j == m) {
                    res.add(i - j);
                    
                    // Use LPS of previous index to 
                    // skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }
            
            // If there is a mismatch
            else {
                
                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return res; 
    }

}