//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] a) {
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        ArrayList<String> sort=new ArrayList<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            String s=a[i];
            String sorted = s.chars().sorted()
              .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
              ).toString();
            int ind=check(sort,sorted);
            if(ind==-1){
                ArrayList<String> temp=new ArrayList<>();
                temp.add(a[i]);
                ans.add(temp);
            }else{
                ans.get(ind).add(a[i]);
            }
        }
    Collections.sort(ans, (list1, list2) -> list1.get(0).compareTo(list2.get(0)));
        return ans;
    }
    public int check(ArrayList<String> sort, String s){
        for(int i=0;i<sort.size();i++){
            if(s.equals(sort.get(i)))return i;
        }
        sort.add(s);
        return -1;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends