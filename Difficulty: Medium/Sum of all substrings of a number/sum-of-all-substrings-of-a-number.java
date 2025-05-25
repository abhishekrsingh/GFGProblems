class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();

        int place_value = 1; // Multiplier to keep track of how many times a digit contributes
        int sum         = 0; // Final sum of all substrings

        for (int i = n - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0'; // Convert character to integer

            // Add the contribution of the current digit
            sum += digit * (i + 1) * place_value;

            // Update the place value for next iteration
            place_value = place_value * 10 + 1;
        }

        return sum; // Return the total sum
    }
}