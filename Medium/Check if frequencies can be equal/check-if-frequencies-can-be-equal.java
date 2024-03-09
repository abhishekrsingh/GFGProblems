//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        int car[]=new int[26];
        for(int i=0;i<s.length();i++){
            car[s.charAt(i)-'a']++;
        }
        
        TreeMap<Integer,Integer> tmap = new TreeMap<Integer,Integer>();
              //freq    count
        
        for(int i=0;i<26;i++){
            int f=car[i];
            if(f==0) continue;
            if(tmap.containsKey(f)){
                tmap.put(f,tmap.get(f)+1);
            }
            else tmap.put(f,1);
        }
        if(tmap.size()>2) return false;         //there are 3 different frequencies, so not possible
        if(tmap.size()==1) return true;         //all freq are equal
        
        int fk=tmap.firstKey();
        int lk=tmap.lastKey();
        
        if(lk==fk+1 && tmap.get(lk)==1){        //remove char which has one extra freq
            return true;
        }
        
        if(fk==1 && tmap.get(fk)==1){           //remove char with freq of 1 
            return true;
        }
        
        
        return false;
        
    }
}