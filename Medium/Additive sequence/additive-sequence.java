//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isAdditiveSequence(String n) {
         boolean ans = false;
         int size =  n.length();
        for (int i = 1; i <  (size > 7 ? 7 : size); i++) {
            for (int j = i + 1; j <  (size > 7 ? 8 : size); j++) {
                int a = Integer.parseInt(n.substring(0, i));
                int b = Integer.parseInt(n.substring(i  , j));
                ans = helper(j, n, a, b, n.length());

                if (ans == true)
                    return true;
            }
        }
        return false;
        // code here
    }

    private   boolean helper(int i, String str, int a, int b, int n) {
        if (i >= n) {
            return true;
        }
        int sum = a + b;
        int len = String.valueOf(sum).length();

        boolean ans = false;
        if (i <= n - len) {
            int integer = Integer.parseInt(str.substring(i, i + len));
            if ((a + b) == integer) {
                ans = helper(i + len, str, b, integer, n);
            }
        }
        return ans;
    }
}
