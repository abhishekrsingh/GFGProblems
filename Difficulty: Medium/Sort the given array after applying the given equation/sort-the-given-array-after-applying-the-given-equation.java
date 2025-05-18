//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        int index=arr.length-1;
        for(int i=0;i<arr.length;i++){
            
            arr[i]=(arr[i]*arr[i]*A)+(B*arr[i])+C;
           
        }
        int prev=-1000000;
       for(int i=1;i<arr.length;i++){
           if(prev==-1000000){
              if(arr[i]-arr[i-1]!=0) prev=arr[i]-arr[i-1];
           }
           else{
               if(prev>0 && arr[i]-arr[i-1]<0){
                   index=i;
                   break;
               }
               else if(prev<0 && arr[i]-arr[i-1]>0){
                   index=i;
                   break;
               }
           }
       }
      if(index-1>=0 && arr[0]>arr[index-1]){
          int temp=index-1;
          for(int i=0;i<temp;i++){
              int hmm=arr[i];
              arr[i]=arr[temp];
              arr[temp]=hmm;
              temp--;
          }
      }
      if(arr[index]>arr[arr.length-1]){
           int temp=arr.length-1;
          for(int i=index;i<temp;i++){
              int hmm=arr[i];
              arr[i]=arr[temp];
              arr[temp]=hmm;
              temp--;
          }
      }
      int i=0,j=index;
      ArrayList<Integer> ans=new ArrayList<>();
        while(i<index && j<arr.length){
            
            if(arr[i]<arr[j]){
                ans.add(arr[i]);
                i++;
            }
            else{
                ans.add(arr[j]);
                j++;
            }
           
        }
        while(i<index){
            ans.add(arr[i]);
            i++;

        }
        while(j<arr.length){
            ans.add(arr[j]);
            j++;

        }
        return ans;
    }
}