class Solution {
    public boolean isSumOfConsecutive(int n) {
        return n > 2 && (n & (n - 1)) != 0;
    }
}