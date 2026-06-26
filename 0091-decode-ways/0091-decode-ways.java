class Solution {
    Integer dp[];
    int help(int n,String s)
    {
        if(n==s.length())
           return 1;
         
        if(dp[n]!=null)
           return dp[n];

         if(s.charAt(n)=='0')
            return dp[n]=0;
        if(n+1<s.length())
        {
            int num=Integer.parseInt(s.substring(n,n+2));
            if(num<=26)
            dp[n]=help(n+1,s)+help(n+2,s);
            else
            dp[n]=help(n+1,s);
        }
        else
        {
            dp[n]=help(n+1,s);
        }
        return dp[n];   
               
    }
    public int numDecodings(String s) {
        int n=s.length(); 
        dp=new Integer[n];
        return help(0,s);  

    }
}