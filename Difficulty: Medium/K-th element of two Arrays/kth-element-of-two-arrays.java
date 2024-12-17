//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length, m = b.length;

        // array to store the merged sorted array
        int[] arr = new int[n + m];
        int i = 0, j = 0, d = 0;

        while (i < n && j < m) {
            
            // If the element of a[] is smaller, insert the
            // element to the sorted array
            if (a[i] < b[j]) {
                arr[d++] = a[i++];
            }
            
            // If the element of b[] is smaller, insert the
            // element to the sorted array
            else {
                arr[d++] = b[j++];
            }
        }

        // Push the remaining elements of a[]
        while (i < n) {
            arr[d++] = a[i++];
        }

        // Push the remaining elements of b[]
        while (j < m) {
            arr[d++] = b[j++];
        }

        return arr[k - 1];
    }
}