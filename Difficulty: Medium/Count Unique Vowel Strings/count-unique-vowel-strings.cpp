class Solution {
  public:
    int vowelCount(string& s) {
        // Map to store the count of each vowel in the string
        map<char, int> mp;
        
        // Iterate through each character in the string
        for(char c: s)
            // Check if the character is a vowel
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') 
                // Increment the count for the vowel in the map
                mp[c]++;
                
        // Number of distinct vowels found in the string
        int sz = mp.size();
        
        // Initialize answer with the number of distinct vowels
        int ans = sz;
        
        // Calculate the factorial of the number of distinct vowels
        // Starting from 2 up to sz-1, multiply to ans
        for(int i = 2; i < sz; i++)  
            ans *= i;
        
        // Multiply the answer by the count of each vowel's occurrences
        for(auto it: mp)    
            ans *= it.second;
        
        // Return the total number of distinct strings
        return ans;
    }
};