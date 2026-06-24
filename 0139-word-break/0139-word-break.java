class Solution {
    HashSet<String>set;
    Boolean dp[];
    boolean help(String s,int idx)
    {
          if(idx==s.length())
             return true;
          if(dp[idx]!=null)
             return dp[idx];
          for(int i=idx;i<s.length();i++)
          {
              String sb=s.substring(idx,i+1);
              if(set.contains(sb)&&help(s,i+1))
                  return dp[idx]=true;
          }
          return dp[idx]=false;     
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
    
        dp=new Boolean[s.length()];
        return help(s,0);

    }
}