class Solution {
  public:
    int sumSubstrings(string& s) {
        int n = s.length();

        int place_value = 1; // Multiplier that keeps track of place values for contribution
        int sum         = 0; // Final sum of all substrings

        for (int i = n - 1; i >= 0; i--) {
            int digit = s[i] - '0'; // Convert character to integer

            // Add contribution of current digit to sum
            sum += digit * (i + 1) * place_value;

            // Update the place value for the next digit (towards left)
            place_value = place_value * 10 + 1;
        }

        return sum; // Return the total sum of all substrings
    }
};