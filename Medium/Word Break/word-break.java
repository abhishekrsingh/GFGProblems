//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<dictionary.size();i++){
            set.add(dictionary.get(i));
        }
        boolean dp[] = new boolean[s.length()+1];
        boolean ans = isPossible(s,set,dp,0);
        if(ans){
            return 1;
        }else{
            return 0;
        }
    }
    public static boolean isPossible(String s,HashSet<String> set,boolean dp[],int pos){
        
        if(pos==s.length()){
            return true;
        }
        
        if(dp[pos]!=false){
            return dp[pos];
        }
        
        String temp = "";
        for(int i=pos;i<s.length();i++){
            temp += s.charAt(i);
            if(set.contains(temp)){//if dictionary contain temp then check for next
                if(isPossible(s,set,dp,i+1)){
                    return dp[i] = true;
                }
            }
        }
        return dp[pos];
    }
}