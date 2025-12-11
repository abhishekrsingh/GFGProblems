class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> output = new ArrayList<>();
        int[] tempArr = new int[arr.length];
        Arrays.fill(tempArr, 0);
        int sumArr = 0;
        int sumAll = 0;
        
        for(int i=0;i<arr.length; i++){
            tempArr[arr[i]-1]++;
            sumArr +=arr[i];
            sumAll += i+1;
        }
        
        for(int i=0; i<tempArr.length; i++){
            if(tempArr[i] > 1){
                output.add(i+1);
                output.add(Math.abs(sumAll - (sumArr - (i+1))));
                break;
            }
        }
        
        return output;
    }
}
