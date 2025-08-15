class Solution {
    public int countRevPairs(int[] arr) {
        return mergeSort(arr,0,arr.length-1);
    }
    
    private int mergeSort(int[] arr,int start,int end){
        int reversePairs = 0;
        if(start < end){
            int mid = start + (end - start)/2;
            reversePairs += mergeSort(arr,start,mid);
            reversePairs += mergeSort(arr,mid+1,end);
            reversePairs += merge(arr,start,mid,end);
        }
        return reversePairs;
    }
    
    private int merge(int[] arr,int start,int mid,int end){
        int count = 0, i = start, j = mid+1, k = 0;
        //To count reverse pairs
        while(i <= mid && j <= end){
            if(arr[i] > 2* arr[j]){
                count += mid- i + 1;
                j++;
            }
            else{
                i++;
            }
        }
        //Merge sort the array
        int[] temp = new int[end-start+1];
        i = start; j = mid+1;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= end){
            temp[k] = arr[j];
            j++;
            k++;
        }
        //Copy the elements from temp array to original array
        for(k = start; k <= end; k++){
            arr[k] = temp[k-start];
        }
        return count;
    }
}