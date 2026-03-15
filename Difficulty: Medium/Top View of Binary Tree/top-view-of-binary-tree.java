/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    int min=Integer.MAX_VALUE;
    ArrayList<int[]> list; // [0]=node.data, [1]=level
    
    public int solve(Node root,int dis)
    {
        if(root==null)
        {
            return 0;
        }
        int left=0;
        int right=0;
        
        min=Math.min(min,dis);
        if(root.left!=null)left=solve(root.left,dis-1);
        if(root.right!=null)right=solve(root.right,dis+1);
        
        return left+right+1;
    }
    
    public void topView(Node root,int dis,int level)
    {
        if(root==null)return;
        
        if(list.get(dis+min)[0]==0 || level<list.get(dis+min)[1])list.set(dis+min,new int[]{root.data,level});
        
        if(root.left!=null)topView(root.left,dis-1,level+1);
        if(root.right!=null)topView(root.right,dis+1,level+1);
    }
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        int totalNodes=solve(root,0);
        list=new ArrayList<>();
        
        for(int i=0;i<totalNodes;i++)
        {
            list.add(new int[]{0,Integer.MAX_VALUE});
        }
        min=0-min;
        topView(root,0,0);
        while(list.get(list.size()-1)[0]==0)list.remove(list.size()-1);
        ArrayList<Integer> result=new ArrayList<>();
        for(int[] i:list)result.add(i[0]);
        return result;
        
    }
}