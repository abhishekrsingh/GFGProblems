//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        // code here
         Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i< arr.length;i++){

            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        int val = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) {
                val = entry.getKey(); // The key is the single element
                break;
            }
        }

        return val;
    }
}