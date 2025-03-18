//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int len = arr.length;
        //state: dp[i][j] : represent whether currSum = j, can be formed from first i-elements.
        
        boolean[][] dp = new boolean[len + 1][sum + 1]; 
                            //extra row,col for sum = 0 and if none of the elements are picked
        
        //if none of the elements (empty subset) then, for sum = 0 , output will be true
        for(int i = 0; i <= len; i++){
            dp[i][0] = true;
        }
        
        for(int i = 1; i <= len; i++){
            for(int j = 1; j<= sum; j++){
                if(arr[i - 1] > j){
                    dp[i][j] = dp[i - 1][j]; // exclude the current element
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        return dp[len][sum];
    }
}