class Solution {
     public int missingNumber(int[] arr) {

        int num = 1;
        int i = 0;
        int l = arr.length;

        while (i < l) {
            if (num == arr[i]) {
                num++;
                i = 0;
                continue;
            }
            i++;
        }

        return num;
    }
}
