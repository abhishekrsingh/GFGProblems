class Solution {
    int min (int a, int b) {
        return a < b ? a : b;
    }
    public int coin(int[] arr) {
        /*It is just a find the smallest problem*/
        int m = Integer.MAX_VALUE;
        for (int x: arr) m = min(m, x);
        return m;
    }
}