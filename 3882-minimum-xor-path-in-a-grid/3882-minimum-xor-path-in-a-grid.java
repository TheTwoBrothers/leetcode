class Solution {
    Integer dp[][][];
    int n,m;
    int help(int x,int y,int z,int grid[][])
    {
        if(x>=m||y>=n)
          return Integer.MAX_VALUE;
        if(x==m-1&&y==n-1)
          return z^grid[x][y];
        if(dp[x][y][z]!=null)
           return dp[x][y][z];
        int right=help(x,y+1,z^grid[x][y],grid);
        int down=help(x+1,y,z^grid[x][y],grid);

        return dp[x][y][z]=Math.min(right,down);
              
    }
    public int minCost(int[][] grid) {
        n=grid[0].length;
       m=grid.length;

       dp=new Integer[m][n][1024];

       return help(0,0,0,grid);
       



        
    }
}