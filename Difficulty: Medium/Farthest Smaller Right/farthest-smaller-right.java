class Solution {
    int n;
    int[] segTree;
    // create segment tree of storing maximum elements index
    public void makeTree(int ind , int start, int end, int[]arr){
        if(start == end){
            this.segTree[ind] = start;
            return;
        }
        
        int mid = start+(end-start)/2;
        makeTree(2*ind+1, start, mid, arr);
        makeTree(2*ind+2, mid+1, end, arr);
        
        this.segTree[ind] = (arr[this.segTree[2*ind+1]] < arr[this.segTree[2*ind+2]]) ? this.segTree[2*ind+1] : this.segTree[2*ind+2];
    }
    


    public int query(int ind, int s, int e, int[]arr, int fs, int fe, int limit){
        if(arr[this.segTree[ind]] >= limit) return -1;
        if(fe < s || e < fs) return -1;
        if(s == e) return s;
        
        int mid = s+(e-s)/2;
        
        if(arr[this.segTree[2*ind+2]] < limit){
            return query(2*ind+2, mid+1, e,arr, fs, fe, limit);
        }
        else{
            return query(2*ind+1, s, mid, arr, fs, fe, limit);
        }
        
    }
    
    public ArrayList<Integer> farMin(int[] arr) {
        this.n = arr.length;
        this.segTree = new int[this.n*4];
        makeTree(0, 0, this.n-1, arr);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i< this.n; i++){
            int qAns = query(0, 0, this.n-1, arr, i+1, this.n-1, arr[i]);
            ans.add(qAns);
        }
        
        return ans;
    }
}