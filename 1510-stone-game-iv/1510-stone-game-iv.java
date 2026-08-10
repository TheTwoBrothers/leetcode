class Solution {
    Boolean dp[];
    boolean help(int n)
    {
        if(n<=0)
          return false;
        if(dp[n]!=null)
            return dp[n];
       
        for(long j=1;j*j<=n;j++)
        {
            if(!help((int)(n-j*j)))
               return dp[n]=true;
        }
       return dp[n]=false;      
    }
    public boolean winnerSquareGame(int n) {
         dp=new Boolean[n+1];
         return help(n);
        
    }
}