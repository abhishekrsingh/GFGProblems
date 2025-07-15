class Solution {
  public:
    bool divby13(string &s) {
        // code here
        int remainder = 0; // Initialize remainder to 0

        // Iterate over each character in the string
        for (char c : s) {
            int digit = c - '0'; // Convert character to integer digit
    
            // Update the remainder: multiply current remainder by 10 to shift left,
            // add the current digit, then take modulo 13 to keep the number small
            remainder = (remainder * 10 + digit) % 13;
        }
    
        // If remainder is 0, the number is divisible by 13
        return remainder == 0;
    }
};