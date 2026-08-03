class Solution {
    Integer dp[][];
    int help(int []st,int i,int turn,int n)
    {
        if(i>=n)
           return 0;
        if(dp[i][turn]!=null)
           return dp[i][turn];
        int next_turn=turn==0?1:0;
        int t1=0;
        int t2=0;
        int t3=0;
        if(turn==0)
        {
           t1=st[i]+help(st,i+1,next_turn,n);
          
           if(i+1<n)
           t2=st[i+1]+st[i]+help(st,i+2,next_turn,n);
           else
             t2=t1;
           if(i+2<n)
           t3=st[i+2]+st[i+1]+st[i]+help(st,i+3,next_turn,n);
           else
             t3=t2;
        }
        else
        {
           t1=-st[i]+help(st,i+1,next_turn,n);

           if(i+1<n)
            t2=-st[i+1]-st[i]+help(st,i+2,next_turn,n);
           else
             t2=t1;

           if(i+2<n)
            t3=-st[i+2]-st[i+1]-st[i]+help(st,i+3,next_turn,n);
           else
             t3=t2;
        }
        return dp[i][turn]=turn==0?Math.max(t1,Math.max(t2,t3)):Math.min(t1,Math.min(t2,t3));      
    } 
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new Integer[n][2];
        int ans=help(stoneValue,0,0,n);
        System.out.println(ans);
        if(ans==0)
           return "Tie";
        else if(ans>0)
           return "Alice";
        else
          return "Bob";      
        
    }
}