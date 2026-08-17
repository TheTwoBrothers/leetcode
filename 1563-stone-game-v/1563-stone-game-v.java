class Solution {
    Integer dp[][];
    int sum[];
    int help(int st[],int i,int j)
    {
         if(i==j)
           return 0;
        if(j-i==1)
         return Math.min(st[i],st[j]);
        if(dp[i][j]!=null)
           return dp[i][j];

        int ans=0;
        
        for(int x=i;x<j;x++)
        {
            int val1 = sum[x] - (i == 0 ? 0 : sum[i - 1]);
            int val2=sum[j]-sum[x];
            
            if(val1==val2)
              ans=Math.max(ans,Math.max(val1+help(st,i,x),val2+help(st,x+1,j)));
            else if(val1>val2)
             ans=Math.max(ans,val2+help(st,x+1,j));
            else
             ans=Math.max(ans,val1+help(st,i,x)); 

        }
        return dp[i][j]=ans;       
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new Integer[n][n];
        sum=new int[n];
        sum[0]=stoneValue[0];
        for(int i =1;i<n;i++)
        {
            sum[i]=sum[i-1]+stoneValue[i];
        }
         for(int i =0;i<n;i++)
        System.out.print(sum[i]+" ");
        return help(stoneValue,0,n-1);
    }
}