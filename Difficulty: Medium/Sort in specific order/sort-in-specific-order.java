class Solution {
    public void sortIt(int[] arr) {
        Arrays.sort(arr);

        int evenCount = 0, oddCount = 0;


        for (int x : arr) {
            if (x % 2 == 0) evenCount++;
            else oddCount++;
        }

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];

      
        int idx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                odd[idx++] = arr[i];
            }
        }

        
        idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even[idx++] = arr[i];
            }
        }

       
        int pos = 0;
        for (int i = 0; i < odd.length; i++) {
            arr[pos++] = odd[i];
        }
        for (int i = 0; i < even.length; i++) {
            arr[pos++] = even[i];
        }
    }
}
