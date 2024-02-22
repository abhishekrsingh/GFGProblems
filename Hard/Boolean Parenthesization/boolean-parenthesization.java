//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int N, String string){
        int i = 0;
		int j = N - 1;
		int isTrue = 1;
		int [][][]dp=new int[string.length()+1][string.length()+1][2];
        for(int [][]rows:dp)
        {
        for(int []col:rows)
        {
        Arrays.fill(col,-1);
        }
        }
		return solve(string, i, j, isTrue, dp);
    }
    
    private static int solve(String string, int i, int j, int isTrue, int [][][]dp) {

		int mod = 1003;
		if (i > j)
			return 0;
		if (i == j)
			if (isTrue == 1) {
				return (string.charAt(i) == 'T') ? 1 : 0;
			} else {
				return (string.charAt(i) == 'F') ? 1 : 0;
			}
			
			if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];

		long ans = 0;

		for (int k = i + 1; k <= j - 1; k += 2) {

			int lT = solve(string, i, k - 1, 1, dp);
			int lF = solve(string, i, k - 1, 0, dp);
			int rT = solve(string, k + 1, j, 1, dp);
			int rF = solve(string, k + 1, j, 0, dp);

			if (string.charAt(k) == '&') {

				if (isTrue==1) {

					ans = ans + lT * rT;
				} else {
					ans = ans + (lT * rF) + (lF * rT) + (lF * rF);
				}
			}

			else if (string.charAt(k) == '|') {
				if (isTrue==1) {
					ans = ans + (lT * rT) + (lF * rT) + (lT * rF);
				} else {
					ans = ans + (lF * rF);
				}
			}

			else if (string.charAt(k) == '^') {
				if (isTrue==1) {
					ans = ans + (lT * rF) + (lF * rT);
				} else {
					ans = ans + (lF * rF) + (lT * rT);
				}
			}
		}

		
		return dp[i][j][isTrue]=(int) (ans % mod);
	}
}