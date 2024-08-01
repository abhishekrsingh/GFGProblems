//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
       Arrays.sort(arr);
       String s1=arr[0];
       String s2=arr[arr.length-1];
       int min=Math.min(s1.length(),s2.length());
       String result="";
       for(int i=0;i<min;i++){
           if(s1.charAt(i)==s2.charAt(i)){
               result=result+s1.charAt(i);
           }
           else{
               break;
           }
       }
       if(result.length()==0){
           return "-1";
       }
       else{
           return result;
       }
    }
}