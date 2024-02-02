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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.arrangeString(s));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
        public String arrangeString(String s)
        {
            //code here.
            char ch[]=s.toCharArray();
            int sum=0;
            String str="";
            ArrayList l1=new ArrayList();
            ArrayList l2 = new ArrayList();
            
            for(int i=0;i<s.length();i++)
            {
             if(Character.isDigit(ch[i])){
             sum =sum +Integer.parseInt(ch[i]+"");
             }
             else
             {
               l2.add(ch[i]);  
                 
             }
            }
              Collections.sort(l2);
            if(sum!=0){
            l1.add(sum);
            l2.addAll(l1);
            }
            
            for(int i=0;i<l2.size();i++)
            {
              str=str+l2.get(i);  
                
            }
            
            
            return str;
        }
}
