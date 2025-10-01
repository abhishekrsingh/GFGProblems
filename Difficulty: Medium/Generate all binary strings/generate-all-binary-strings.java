class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> list = new ArrayList<>();
        generate(n,"",list);
        return list;   
    }
    
    public static void generate(int n, String curr, ArrayList<String> result){
        
        if(curr.length() == n){
            result.add(curr);
            return;
        }
        
        generate(n, curr + "0",result);
        generate(n, curr + "1", result);
    }
}
