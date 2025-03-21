//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        if (prices == null || prices.length < 2) return 0;
        int firstBuy = Integer.MAX_VALUE, firstProfit = 0;
        int secondBuy = Integer.MAX_VALUE, secondProfit = 0;
        for (int price : prices) {
            firstBuy = Math.min(firstBuy, price);
            firstProfit = Math.max(firstProfit, price - firstBuy);
            secondBuy = Math.min(secondBuy, price - firstProfit);
            secondProfit = Math.max(secondProfit, price - secondBuy);
        }
        return secondProfit;
    }
}
