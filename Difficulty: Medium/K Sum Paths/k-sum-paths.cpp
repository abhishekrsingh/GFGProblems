/*
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
  public:
    void dfs(int &ans , Node *nd , int k , int sum, map<int,int>&mp){
        sum+=nd->data;
        if(mp.find(sum-k) !=mp.end())ans+=mp[sum-k];
        mp[sum]++;
        if(nd->left)dfs(ans , nd->left , k , sum ,mp);
        if(nd->right)dfs(ans , nd->right , k , sum , mp);
        
        if(mp[sum] ==1)mp.erase(sum);
        else mp[sum]--;
    }
    int countAllPaths(Node *root, int k) {
        // code here
        if(root ==NULL)return 0;
        int ans = 0;
        map<int,int>mp;
        mp[0] = 1;
        dfs(ans , root , k , 0,mp );
        return ans;
    }
};