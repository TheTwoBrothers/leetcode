class Solution {
    public int climbStairs(int n, int[] cost) {
        int dp[]=new int[n+1];

        for(int i=1;i<=n;i++)
           dp[i]=Integer.MAX_VALUE;

        for(int i=1;i<=n;i++)
        {
            if(i-1>=0)
            {
                dp[i]=Math.min(dp[i],dp[i-1]+cost[i-1]+(int)Math.pow(i-(i-1),2));
            }
            if(i-2>=0)
            {
                dp[i]=Math.min(dp[i],dp[i-2]+cost[i-1]+(int)Math.pow(i-(i-2),2));   
            }
            if(i-3>=0)
            {
                dp[i]=Math.min(dp[i],dp[i-3]+cost[i-1]+(int)Math.pow(i-(i-3),2));
            }
        }
        return dp[n];   
    }
}