class Solution {
  public:
    bool isPalinSent(string &s) {
        // code here
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters on the left
            while (left < right && !isalnum(s[left]))
                left++;
            // Skip non-alphanumeric characters on the right
            while (left < right && !isalnum(s[right]))
                right--;
            
            // Compare characters in a case-insensitive manner.
            // If they are not the same, the sentence isn't a palindrome.
            if (tolower(s[left]) != tolower(s[right]))
                return false;
            
            left++;
            right--;
        }
        
        return true;
    }
};