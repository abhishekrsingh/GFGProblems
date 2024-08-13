//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        ArrayList<Integer> num = new ArrayList<>();
        
        int n1=arr1.length;
        int n2=arr2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                num.add(arr1[i]);
                i++;
            } else {
                num.add(arr2[j]);
                j++;
            }
        }
        
 
        while (i < n1) {
            num.add(arr1[i]);
            i++;
        }
       
        while (j < n2) {
            num.add(arr2[j]);
            j++;
        }
        int sum=0;
        int n=num.size();
        if(n%2==0){
            int mid1=(n/2) - 1;
            int mid2=n/2;
            sum=num.get(mid1)+num.get(mid2);
        }else{
            int mid=n/2;
            sum=num.get(mid);
        }
        return sum;

    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends