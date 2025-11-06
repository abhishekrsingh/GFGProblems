class Solution {
    static boolean isSquare(int x) {
        int sqRoot = (int) Math.sqrt(x);
        return (sqRoot * sqRoot == x);
    }
    static int minSquares(int n) {
      
        // if n is a perfect square
        if (isSquare(n)) {
            return 1;
        }

        // if the number is the
        // sum of two perfect squares
        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - (i * i))) {
                return 2;
            }
        }
        
        // if n is of the form 4^a (8*b + 7).
        while (n > 0 && n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        // since all the other cases have been evaluated, 
        // the answer can only then be 3 if the program 
        // reaches here
        return 3;
    }
}