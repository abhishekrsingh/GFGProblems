//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here        
        int leftSmall[]=new int[N];
        leftSmall[0]=1;
        for(int i=1;i<N;i++){
            if(ratings[i]>ratings[i-1])leftSmall[i]=leftSmall[i-1]+1;
            else leftSmall[i]=1;
        }
        int right=1;
        for(int i=N-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])right++;
            else right=1;
            leftSmall[i]=Math.max(leftSmall[i],right);
        }
        int ans=0;
        for(int i=0;i<N;i++){
            ans+=leftSmall[i];
        }
        return ans;
    }
}
