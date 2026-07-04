class Solution {
    public int minScore(int n, int[][] roads) {
        int vis[]=new int[n+1];
        List<List<int[]>>adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
          adj.add(new ArrayList<>());

        for(int rd[]:roads)
        {
            adj.get(rd[0]).add(new int []{rd[1],rd[2]});
            adj.get(rd[1]).add(new int []{rd[0],rd[2]});
        }
        int ans=100000;
        Queue<Integer>q=new LinkedList<>();
        q.add(1);
        vis[1]=1;
        while(!q.isEmpty())
        {
            int node= q.poll();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int data[]=adj.get(node).get(i);
                ans=Math.min(ans,data[1]);
                if(vis[data[0]]!=0)
                   continue;
                q.add(data[0]);
                 vis[data[0]]=1;
                   
            }
        }
        return ans;
    }
}