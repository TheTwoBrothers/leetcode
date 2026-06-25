class Solution {
    Boolean dp[][];
    
    boolean help(String s,String p,int i,int j)
    {
        if(i==s.length()&&j==p.length())
           return true;
           
        if(i==s.length())
        {
            for(int x=j;x<p.length();x++)
            {
                if(p.charAt(x)!='*')
                {
                   if(x+1<p.length()&&p.charAt(x+1)=='*')
                      continue;
                    return false;  
                }
            }
            return true;
        }
        
        if(j==p.length())
          return false;

        if(dp[i][j]!=null)
           return dp[i][j];
           
        char ch1=s.charAt(i);
        char ch2=p.charAt(j);

       
        if(j+1<p.length() && p.charAt(j+1)=='*')
        {
            if(ch1==ch2 || ch2=='.') {
                
                dp[i][j] = help(s,p,i+1,j) || help(s,p,i,j+2);
            } else {
               
                dp[i][j] = help(s,p,i,j+2);
            }
        }
       
        else if(ch1==ch2)
        {
            dp[i][j]=help(s,p,i+1,j+1);
        }
        else if(ch2=='.')
        {
            dp[i][j]=help(s,p,i+1,j+1);
        }
        else
        {
            return dp[i][j]=false;
        } 
        
        return dp[i][j];       
    }
    
    public boolean isMatch(String s, String p) {
        
        dp=new Boolean[s.length()+1][p.length()+1];
        return help(s,p,0,0);
    }
}