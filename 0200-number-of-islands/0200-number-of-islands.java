class Solution {
    int vis[][];
    void check(char grid[][],int x,int y,int n,int m)
    {
        
        vis[x][y]=1;
        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};

        for(int i=0;i<4;i++)
        {
            int x1=x+dx[i];
            int y1=y+dy[i];
            if(x1>=0&&x1<n&&y1>=0&&y1<m&&vis[x1][y1]!=1&&grid[x1][y1]=='1')
            {
                check(grid,x1,y1,n,m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        vis=new int [n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1'&&vis[i][j]==0)
                {
                    check(grid,i,j,n,m);
                    ans++;
                }
            }
        }
        return ans;
    }
}