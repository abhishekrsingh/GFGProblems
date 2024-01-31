//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        int count=0,max=0,i=0,j;
        String s="";
        while(i<S.length())
        {
            j=i;
            while(j<S.length())
            {
                if(s.contains(Character.toString(S.charAt(j))))
                {
                    s="";
                    max=Math.max(count,max);
                    count=0;
                    break;
                }
                else{
                    s+=S.charAt(j);
                    count++;
                    j++;
                }
                
            }
            i+=1;
        }
        max=Math.max(max,count);
        return max;
    }
}