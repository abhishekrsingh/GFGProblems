//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> topoSort(List<List<Integer>> adj, int V){
        int indegree[] = new int[V];
        
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
         // If topo size is less than V, there's a cycle or invalid case
        if (topo.size() < V) {
            return new ArrayList<>(); // Return empty list for invalid cases
        }
        
        return topo;
    }
    
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n-1; i++){
            
            String str1 = dict[i];
            String str2 = dict[i+1];
            
            int minLen = Math.min(str1.length(),str2.length());
            
            for(int ptr = 0; ptr<minLen; ptr++){
                char ch1 = str1.charAt(ptr);
                char ch2 = str2.charAt(ptr);
                
                if(ch1 != ch2){
                    adj.get(ch1 - 'a').add(ch2 - 'a');
                    break;
                }
            }
            
        }
            
        List<Integer> topo = topoSort(adj,k);
        
        String ans = "";
        
        for(int it : topo){
            ans = ans + (char)(it + (int)('a'));
        }
        
        return ans;
            
        
    }
}