//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
           int l=0;
           int n=arr.length;
           int r=n-1;
           int max=0;
           while(l<r)
           {
            //   System.out.println((r-l)*Math.min(arr[],l));
               max=Math.max(max,(r-l)*Math.min(arr[r],arr[l]));
               if(arr[l]<arr[r])
               l++;
               else 
               r--;
           }
           return max;
    }
}