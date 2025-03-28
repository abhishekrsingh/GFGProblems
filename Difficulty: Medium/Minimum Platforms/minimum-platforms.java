//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        int temp[][] = new int[arr.length*2][2];
        for(int i = 0;i<arr.length;i++){
            temp[i][0] = arr[i];
            temp[i][1] = 2;
        }
        
        for(int i = 0;i<dep.length;i++){
            temp[i+arr.length][0] = dep[i];
            temp[i+arr.length][1] = 1;
        }
        
        Arrays.sort(temp, (a,b) -> {
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int c = 0;
        int max = 1;
        for(int i = 0; i<temp.length; i++) {
            // System.out.println(temp[i][0] + " " + temp[i][1]);
            if(temp[i][1]==2) c++;
            else c--;
            max = Math.max(max, c);
        }
        return max;
    }
}
