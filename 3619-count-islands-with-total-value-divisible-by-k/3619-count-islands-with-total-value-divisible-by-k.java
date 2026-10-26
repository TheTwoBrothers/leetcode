class Solution {
    public int countIslands(int[][] grid, int mod) {
        int n=grid.length;
        int m=grid[0].length;

        int vis[][]=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]>=1&&vis[i][j]==0)
                {
                    Queue<int[]>q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    long  sum=grid[i][j];
                    vis[i][j]=1;
                     while(!q.isEmpty())
                    {
                        
                        int len=q.size(); 
                        for(int k=0;k<len;k++)
                        {
                            int temp[]=q.poll();

                            int x[]={0,0,1,-1};
                            int y[]={1,-1,0,0};
                            for(int l=0;l<4;l++)
                            {
                
                                int nx=temp[0]+x[l];
                                int ny=temp[1]+y[l];
                                if(nx>=0&&nx<n&&ny>=0&&ny<m)
                                {
                                    if(vis[nx][ny]==0&&grid[nx][ny]>0)
                                    {
                                        q.add(new int[]{nx,ny});
                                        vis[nx][ny]=1;
                                        sum+=grid[nx][ny];
                                    }
                                }   
                            }

                        }  
                    }
                    if(sum%mod==0)
                       ans++;
                }
            }
        }
        return ans;
    }
}