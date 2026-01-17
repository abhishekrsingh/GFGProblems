class Solution {
    public int minMen(int arr[]) {
        // Using Greedy
        int n = arr.length;
        ArrayList<int[]> intervals = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(arr[i]!=-1){
                intervals.add(new int[]{i-arr[i], i+arr[i]});
            }
        }
        
        if (intervals.size() == 0) return -1; // no intervals formed
        
         // sort by ascending starts then by descending ends
        Collections.sort(intervals, (a, b) -> {
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        
        int count = 0; // kitne bande use hue
        int coveredTill = -1; // abhi tak kaha tak cover ho chuka
        int nextReach = -1; // next banda max kaha tak cover karega
        
        int i=0;
        while(coveredTill < n-1){
            // jo intervals current coverage se start ho sakte hain, unme se
            // jo sabse aage tak cover kare, usko choose karna hai
            while(i<intervals.size() && intervals.get(i)[0]<=coveredTill+1){
                nextReach = Math.max(nextReach, intervals.get(i)[1]);
                i++;
            }
            
            // Agar koi bhi banda coverage badha hi nahi pa raha
            if (nextReach <= coveredTill) return -1;
            
            // extend coverage and mens count
            coveredTill = nextReach;
            count++;
        }
        
        return count;
    }
}