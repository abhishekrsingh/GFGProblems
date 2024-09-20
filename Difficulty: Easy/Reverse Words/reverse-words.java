//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends





class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        // Initialize variables to store the reversed string and the current word
        String reversedString = "";
        String currentWord = "";

        // Loop through the input string from right to left
        for (int i = S.length() - 1; i >= 0; i--) {
            // If the current character is not a period (.)
            if (S.charAt(i) != '.') {
                // Add the character to the current word in reverse order
                currentWord = S.charAt(i) + currentWord;
            } else {
                // If we encounter a period, add the current word to the result with a period
                reversedString += currentWord + ".";

                // Reset the currentWord variable to start building the next word
                currentWord = "";
            }
        }

        // Add the last word (no period at the end) to the result
        reversedString += currentWord;

        // Return the reversed string
        return reversedString;
    }
}