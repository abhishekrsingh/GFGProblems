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
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) 
    {
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
            int t=target-arr[i];
            int l=i+1,h=arr.length-1;
            while(l<h)
            {
                if(arr[l]+arr[h]==t)
                {
                    if(arr[l]==arr[h])
                    {
                        c=c+((h-l+1)*(h-l))/2;
                        break;
                    }
                    else
                    {
                        int a=1,b=1;
                        while(arr[l+1]==arr[l])
                        {
                            l++;
                            a++;
                        }
                        while(arr[h-1]==arr[h])
                        {
                            h--;
                            b++;
                        }
                        c=c+(a*b);
                        l++;
                        h--;
                    }
                }
                else if(arr[l]+arr[h]>t)
                    h--;
                else
                    l++;
            }
            
        }
        return c;
    }
}