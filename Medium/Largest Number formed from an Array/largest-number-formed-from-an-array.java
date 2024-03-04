//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        StringBuilder temp = new StringBuilder();
        Arrays.sort(arr,new Comparator<String>(){
            @Override 
            public int compare(String x, String y){
                String a = x+y;
                String b = y+x;
                return b.compareTo(a);
            }
        });
        for(String x:arr)temp.append(x);
        return temp.toString();
    }
}