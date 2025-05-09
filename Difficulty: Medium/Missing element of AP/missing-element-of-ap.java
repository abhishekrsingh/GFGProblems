//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int n = arr.length;

        // If exactly one element is missing, then we can find
        // difference of arithmetic progression using following
        // formula.
        int diff = (arr[1] - arr[0] == arr[n-1] - arr[n-2]) ? arr[1] - arr[0] : 
          ((arr[1] - arr[0] == (arr[n-1] - arr[0])/n) ? arr[1] - arr[0] : 
           arr[n-1] - arr[n-2]);

        if (diff == 0) return arr[0];
        
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // if mid == (nth position of element in AP)-1
            // the missing element will exist in right half 
            if ((arr[mid] - arr[0]) / diff == mid)
                lo = mid + 1;

            // the missing element will exist in left half
            else
                hi = mid - 1;
        }

        // after breaking out of binary search loop the missing element
        // will exist between high and low
        return arr[hi] + diff;
    }
}
