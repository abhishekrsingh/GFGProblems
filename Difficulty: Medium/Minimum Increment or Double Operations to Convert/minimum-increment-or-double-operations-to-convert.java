class Solution {
    public int countMinOperations(int arr[]) {
        int ans = 0, maxDouble = 0;
        for(int i=0;i<arr.length;i++){
            int x = arr[i];
            int incrementOperation = 0;
            int doubleOperation = 0;
            while(x!=0){
                if(x%2==0){
                    doubleOperation++;
                    x /= 2;
                }else{
                    incrementOperation++;
                    x--;
                }
            }
            // Increment operation of an element is independent 
            // and cannot be clubbed with group operation
            ans += incrementOperation;
            // Double operation is common for all elements
            // So we find the max double operation per element
            maxDouble = Math.max(maxDouble, doubleOperation);
        }
        
        return ans + maxDouble;
    }
}