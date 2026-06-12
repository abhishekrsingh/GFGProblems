class Solution {
  public:
    // Helper Function: Factorial calculate karne ke liye
    long long getFactorial(int n) {
        long long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    long long findRank(string& s) {
        int n = s.size();
        long long ans = 0;
        
        // Har character ke liye loop chalayenge
        for (int i = 0; i < n; i++) {
            int count = 0;
            
            // s[i] ke right side mein jitne chote characters hain, unhe count karo
            for (int j = i + 1; j < n; j++) {
                if (s[i] > s[j]) {
                    count++; // Chota character mila, count badhao
                }
            }
            
            // Bache hue characters ke total permutations nikaalo
            long long remaining_slots_factorial = getFactorial(n - 1 - i);
            
            // Ans mein combinations add karo
            ans += count * remaining_slots_factorial;
        }
        
        // 1-based index rank ke liye final ans mein +1 return karo
        return ans + 1;
    }
};