class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int max = 0;
        int i = 0;
        int j = arr.length-1;
        
        while(i < j){
            int min = Math.min(arr[i],arr[j]);
            int w = j-i;
            max = Math.max(max,(min*w));
            if(arr[i] < arr[j]) i++;
            else j--;
        }
        
        return max;
    }
}