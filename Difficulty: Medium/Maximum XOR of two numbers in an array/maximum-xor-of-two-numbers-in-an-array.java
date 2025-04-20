//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxXor(int[] nums) {
        // code here
        int ans = 0;
        int[] arr = new int[nums.length];
        
        Trie trie = new Trie();
        for(int i : nums)
            trie.insert(i);
            
        for(int i : nums)
            ans = Math.max(ans, trie.max(i));
        
        return ans;
    }
}

class TrieNode{
    
    public TrieNode[] child = null;
    
    TrieNode() {
        child = new TrieNode[2];
    }
    
    public String toString(){
        
        String s = "";
            
        if(this.child[0] == null)
            s = s+'N';
        else 
            s = s+'0';
            
        if(this.child[1] == null)
            s = s+'N';
        else 
            s = s+'1';
            
        return s;
    }
}

class Trie{

    TrieNode trie = null;
    
    Trie(){
        this.trie = new TrieNode();
    }
    
    public void insert(int num){
        
        TrieNode tmp = trie;
        int i = 31;
        while(i-- >= 0){
            int f = ((num >> i)&1);
            if(tmp.child[f] == null){
                tmp.child[f] = new TrieNode();
            }
            tmp = tmp.child[f];
        }
    }
    
    public int max(int num){
        int a = 0,i = 31;
        
        TrieNode tmp = trie;
        while(i-- >= 0){
            int f = 1-((num >> i)&1);
            if(tmp.child[f] != null){
                a |= 1<<i;
                tmp = tmp.child[f];
            }else{
                tmp = tmp.child[1-f];
            }
        }
        
        return a;
    }
}