//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(Integer num:arr)
        {
            if(num>=0)   pos.add(num);
            else neg.add(num);
        }
        arr.clear();
        int k=0,posind=0,negind=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(posind<pos.size() && negind<neg.size())
        
        {
            if(k%2==0)  ans.add(pos.get(posind++));
            else ans.add(neg.get(negind++));
            k++;
        }
        while(posind<pos.size())
        {
            ans.add(pos.get(posind++));
        }
        while(negind<neg.size())
        {
            ans.add(neg.get(negind++));
        }
        arr.clear();
        arr.addAll(ans);
    }
}