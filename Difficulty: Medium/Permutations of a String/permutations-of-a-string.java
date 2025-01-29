//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
         ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];

        // Sort the characters to handle duplicates
        Arrays.sort(chars);

        // Start backtracking
        backtrack(chars, visited, new StringBuilder(), result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] visited, StringBuilder current, ArrayList<String> result) {
        // Base case: if the current permutation is complete
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip already visited characters
            if (visited[i]) continue;

            // Skip duplicates: if the current character is the same as the previous one,
            // and the previous one has not been visited in this recursive call
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;

            // Mark the character as visited and add it to the current permutation
            visited[i] = true;
            current.append(chars[i]);

            // Recur to build the rest of the permutation
            backtrack(chars, visited, current, result);

            // Backtrack: unmark the character and remove it from the current permutation
            visited[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}