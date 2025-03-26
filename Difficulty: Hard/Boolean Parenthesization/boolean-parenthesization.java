//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int countWays(String s) {
        int n = s.length();
        int[][] trueWays = new int[n][n];
        int[][] falseWays = new int[n][n];

        for (int i = 0; i < n; i += 2) {
            trueWays[i][i] = (s.charAt(i) == 'T') ? 1 : 0;
            falseWays[i][i] = (s.charAt(i) == 'F') ? 1 : 0;
        }

        for (int len = 2; len < n; len += 2) {
            for (int i = 0; i < n - len; i += 2) {
                int j = i + len;
                for (int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);
                    int leftTrue = trueWays[i][k - 1], leftFalse = falseWays[i][k - 1];
                    int rightTrue = trueWays[k + 1][j], rightFalse = falseWays[k + 1][j];

                    if (op == '&') {
                        trueWays[i][j] += leftTrue * rightTrue;
                        falseWays[i][j] += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                    } else if (op == '|') {
                        trueWays[i][j] += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                        falseWays[i][j] += leftFalse * rightFalse;
                    } else if (op == '^') {
                        trueWays[i][j] += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                        falseWays[i][j] += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                    }
                }
            }
        }
        return trueWays[0][n - 1];
    }
}