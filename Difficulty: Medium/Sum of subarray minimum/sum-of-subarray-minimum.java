class Solution {
    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // pop until you find a smaller element or stack becomes empty
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            // if empty, no smaller to left; else top of stack is NSL
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            // pop until you find a strictly smaller element or stack becomes empty
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            // if empty, no smaller to right; else top of stack is NSR
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            // distance to previous smaller on left
            int leftD = i - NSL[i];
            // distance to next smaller on right
            int rightD = NSR[i] - i;
            // each element contributes arr[i] * leftD * rightD
            sum += arr[i] * leftD * rightD;
        }
        return sum;
    }
}
