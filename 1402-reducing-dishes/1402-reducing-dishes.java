class Solution {
     Integer  dp[][];
     int help(int st[],int i,int j)
     {
        if(i>=st.length)
           return 0;
        if(dp[i][j]!=null)
         return dp[i][j];

        int take=st[i]*(j+1)+help(st,i+1,j+1);    
        int notTake=help(st,i+1,j);

        return dp[i][j]=Math.max(take,notTake);    
     }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        dp=new Integer[satisfaction.length][satisfaction.length];
        return help(satisfaction,0,0);
    }
}