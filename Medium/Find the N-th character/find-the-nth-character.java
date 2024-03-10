//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        String one="1";
        String zero="0";
        for(int i=0;i<r;i++)
        {  String no=one;
           String nz=zero;
           no+=zero;
           nz+=one;
           zero=nz;
           one=no;
        }
      
        String ns="";
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='1')
                {
                    ns+=one;
                }
                else
                {
                     ns+=zero;
                }
                if(ns.length()>n) break;
            } 
         
        return ns.charAt(n);
    }
}