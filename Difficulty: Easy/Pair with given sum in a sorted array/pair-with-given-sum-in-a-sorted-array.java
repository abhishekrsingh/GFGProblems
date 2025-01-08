//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int l=0;
        int r=arr.length-1;
        int c=0;
        while(l<r){
            if(arr[l]+arr[r]>target){
                r--;
            }else if(arr[l]+arr[r]<target){
                l++;
            }else{
                int el=arr[l],er=arr[r];
                int cl=0,cr=0;
                while(l<=r&&arr[l]==el){
                    l++;
                    cl++;
                }
                while(l<=r&&arr[r]==er){
                    r--;
                    cr++;
                }
                if(el==er){
                    c=c+(cl*(cl-1))/2;
                }else{
                    c+=cl*cr;
                }
            }
        }
        return c;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends