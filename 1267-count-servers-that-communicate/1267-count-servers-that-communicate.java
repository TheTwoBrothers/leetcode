class Solution {
    int vis[][];
    int n,m;
    int help(int grid[][],int x,int y)
    {
        boolean ans=false;
        for(int i=0;i<n;i++)
        {
            if(i==x)continue;
            if(grid[i][y]==1)
            {
                vis[i][y]=1;
                ans=true;
            }
        }
        for(int i=0;i<m;i++)
        {
            if(i==y)continue;
            if(grid[x][i]==1)
            {
                vis[x][y]=1;
                ans=true;
            }
        }
        return ans?1:-1;

    }
    public int countServers(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        vis=new int[n][m];

        

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0&&grid[i][j]==1)
                {
                    
                    vis[i][j]=help(grid,i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==1)
                   ans++;
            
            }
        } 
        return ans;   
    }
}