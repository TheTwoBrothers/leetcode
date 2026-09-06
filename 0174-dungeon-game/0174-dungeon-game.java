class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
       int n=dungeon.length;
       int m=dungeon[0].length;

       int dp[][]=new int[n+1][m+1];
       for(int i=0;i<n+1;i++)
           dp[i][m]=Integer.MAX_VALUE; 
       for(int i=0;i<m+1;i++)
           dp[n][i]=Integer.MAX_VALUE; 

        dp[n-1][m]=1;
        dp[n][m-1]=1;

        for(int i =n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                int min=Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
                dp[i][j]=min<=0?1:min;
            }
        }
        return dp[0][0];   
    }
}