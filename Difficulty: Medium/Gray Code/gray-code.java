class Solution {
    public ArrayList<String> helper(int n){
        if(n==1){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("0");
            arr.add("1");
            return arr;
        }
        ArrayList<String> arr = helper(n-1);
        ArrayList<String> req = new ArrayList<>();
        for(int i = 0 ; i < arr.size() ; i++)
            req.add("0"+arr.get(i));
        for(int i = arr.size()-1 ; i >= 0 ; i--)
            req.add("1"+arr.get(i));
        return req;
    }
    public ArrayList<String> graycode(int n)
    {
        ArrayList<String> req = helper(n);
        return req;
    }
}