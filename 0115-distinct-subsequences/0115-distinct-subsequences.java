class Solution {
    Integer dp[][];
    int help(String s,String t,int i,int j)
    {
        if(j==t.length())
          return 1; 
        if(i>=s.length())
           return 0;
        if(dp[i][j]!=null)
           return dp[i][j];
        if(s.charAt(i)!=t.charAt(j))
           dp[i][j]=help(s,t,i+1,j);
        else
        {
          dp[i][j]=help(s,t,i+1,j+1)+help(s,t,i+1,j);
        }
        return dp[i][j];            
            
    }
    public int numDistinct(String s, String t) {
        dp=new Integer[s.length()][t.length()];
    
         return help(s,t,0,0);

    }
} 