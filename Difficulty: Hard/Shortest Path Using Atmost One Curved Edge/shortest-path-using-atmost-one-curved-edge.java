class Solution {
    public int shortestPath(int V, int source, int destination, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i[]:edges){
            graph.get(i[0]).add(new int[]{i[1],i[2],i[3]});
             graph.get(i[1]).add(new int[]{i[0],i[2],i[3]});
        }

        
        PriorityQueue<int[]> que=new PriorityQueue<>(
            
            new Comparator<int[]>(){
                public int compare(int a[],int b[]){
                    return Integer.compare(a[1],b[1]);
                }
            });
            
            que.add(new int[]{ source,0,0});
            int vis[][]=new int[V][2];
            for(int i[]:vis) Arrays.fill(i,-1);
            
            while(que.size()>0){
                int temp[]=que.poll();
                int flag=temp[2];
                if(temp[0]==destination) return temp[1];
                for(int i[]:graph.get(temp[0])){
                    int a=i[0];
                    int cost=i[1];
                    int cost2=i[2];
                 
                    if(flag==1){
                            if(vis[a][1]==-1 || vis[a][1]>temp[1]+cost){
                                
                            vis[a][1]=temp[1]+cost;
                            que.add(new int[]{a,temp[1]+cost,1});}

                    }
                    else{
                         if(vis[a][0]==-1 || vis[a][0]>temp[1]+cost){
                             vis[a][0]=temp[1]+cost;
                                     que.add(new int[]{a,temp[1]+cost,0});}
                                      if(vis[a][1]==-1 || vis[a][1]>temp[1]+cost2){
                                          vis[a][1]=temp[1]+cost2;
                         que.add(new int[]{a,temp[1]+cost2,1});}
                    }
                }
            }
            return -1;
    }
}