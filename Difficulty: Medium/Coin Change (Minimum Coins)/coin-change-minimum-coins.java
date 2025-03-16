//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int n=coins.length;
        int [][] dp=new int [n][sum+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        int ans=solve(dp,coins,sum,0,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int solve(int [][]dp, int [] coins, int sum, int curr,int i) 
    {
    if (sum == curr) return 0;
    if (i >= coins.length || sum < curr) return Integer.MAX_VALUE;
    if (dp[i][curr] != -1) return dp[i][curr];

    int take = Integer.MAX_VALUE;
    if (sum >= curr + coins[i]) {
        int res = solve(dp, coins, sum, curr + coins[i], i);
        if (res != Integer.MAX_VALUE) take = 1 + res;
    }

    int skip = solve(dp, coins, sum, curr, i + 1);

    return dp[i][curr] = Math.min(skip, take);
}
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends