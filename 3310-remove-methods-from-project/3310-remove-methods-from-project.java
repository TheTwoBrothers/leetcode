class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>>adj=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
           adj.add(new ArrayList<>());
           ls.add(i);
        }
        List<Integer>ans=new ArrayList<>();
        for(int []i: invocations)
        {
            int u=i[0];
            int v=i[1];
            adj.get(u).add(v);
        }   
        // ls.add(k);
        Queue<Integer>q=new LinkedList<>();
         int vis[]=new int [n];
        q.add(k);
         vis[k]=1;

         while(!q.isEmpty())
         {
            int len=q.size();

            for(int i=0;i<len;i++)
            {
                int node=q.poll();

                for(int j=0;j<adj.get(node).size();j++)
                {
                    if(vis[adj.get(node).get(j)]==0)
                    {
                        vis[adj.get(node).get(j)]=1;
                        q.add(adj.get(node).get(j));
                    }
                }
            }
         }
        //  for(int i=0;i<n;i++)
        //  {
        //     if(vis[i]==1)
        //        System.out.println(i);
        //  }
         for(int i=0;i<n;i++)
         {
            if(vis[i]==1)
               continue;
            for(int j=0;j<adj.get(i).size();j++)
            {
                if(vis[adj.get(i).get(j)]==1)
                   return ls;
            }
            ans.add(i);   
         }
         return ans;
    }
}