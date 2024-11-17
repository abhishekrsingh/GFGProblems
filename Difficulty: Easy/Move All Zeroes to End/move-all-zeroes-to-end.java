//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        
        int ptr_1 = 0, ptr_2 = 0;
        
        while(ptr_1 < n - 1 && arr[ptr_1] != 0){
            ptr_1++;
        }
        
        if(ptr_1 == n-1) return;
        ptr_2 = ptr_1 + 1;
        
        while(ptr_1 < n && ptr_2 < n){
            while(ptr_2 < n && arr[ptr_2] == 0){
                ptr_2++;
            }
            
            if(ptr_2 == n) break;
            
            arr[ptr_1] = arr[ptr_2];
            arr[ptr_2] = 0;
            ptr_1++;
            ptr_2++;
        }
        
        return;
    }

}