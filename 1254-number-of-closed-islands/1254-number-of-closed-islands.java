class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int vis[][]=new int[n][m];

        for(int i=0;i<n;i++)
        {
            if(grid[i][0]==1)
            {
                vis[i][0]=1;
            }
            else
            {
                vis[i][0]=-1;
            }

        }   
        for(int i=0;i<n;i++)
        {
            if(grid[i][m-1]==1)
            {
                vis[i][m-1]=1;
            }
            else
            {
                vis[i][m-1]=-1;
            }

        }   
        for(int i=0;i<m;i++)
        {
            if(grid[n-1][i]==1)
            {
                vis[n-1][i]=1;
            }
            else
            {
                vis[n-1][i]=-1;
            }

        }
        
        for(int i=0;i<m;i++)
        {
            if(grid[0][i]==1)
            {
                vis[0][i]=1;
            }
            else
            {
                vis[0][i]=-1;
            }

        }
        
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                if(grid[i][j]==1)
                   vis[i][j]=1;
            }
        }
        int ans=0;
        Queue<int []> q=new LinkedList<>();
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                if(grid[i][j]==0&&vis[i][j]==0)
                {
                    q.add(new int[]{i,j});
                    vis[i][j]=1;
                    boolean yes=true;
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
                                
                                if(vis[nx][ny]==-1)
                                  {
                                      yes=false;
                                  }
                                if(vis[nx][ny]==0)
                                {
                                    q.add(new int[]{nx,ny});
                                    vis[nx][ny]=1;
                                }   
                            }

                        }  
                    }
                    if(yes)
                       ans++;
                }
            }
        }
        return ans;
           
        
    }
}