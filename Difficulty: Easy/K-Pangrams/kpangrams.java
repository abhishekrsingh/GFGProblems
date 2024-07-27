//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
                int count=0;
        if(str.replace(" ", "").length() < 26)
        return false;
        
        for(char i='a';i<='z';i++)
       {
          if(!str.contains(String.valueOf(i)))
              count++;  
       }
       if(count > k){
          return false;
       }
       return true;
    }
}