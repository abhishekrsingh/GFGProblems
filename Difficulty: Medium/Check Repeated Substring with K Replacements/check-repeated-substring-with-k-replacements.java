class Solution {
    public boolean kSubstr(String s, int k) {
        if(s.length() % k != 0) return false;  //check divisibility
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i += k){
            String chunk = s.substring(i, i+k);
            map.put(chunk, map.getOrDefault(chunk,0) + 1);
        }
        
        //find max frequency
        int maxFreq = 0;
        for(int freq : map.values()){
            maxFreq = Math.max(maxFreq, freq);
        }
        
        int totalChunks = s.length() / k;
        return (totalChunks - maxFreq) <= 1;
    }
}