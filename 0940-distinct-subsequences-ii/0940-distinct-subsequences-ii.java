class Solution {
    public int distinctSubseqII(String s) {
       long ans=0;
       int mod=1000000007;
       long last[]=new long[26];

       for(int i=0;i<s.length();i++)
       {
            char ch=s.charAt(i);
            long newc=(1+ans)%mod;
            ans=(ans+newc-last[ch-'a']+mod)%mod;
            last[ch-'a']=newc;
       } 
       return (int)ans;
    }
}