class Solution {
    public int minOperations(String s) {
        int n=s.length();
        if(n==1)
          return 0;
        if(n==2)
        {
            if(s.charAt(0)<=s.charAt(1))
               return 0;
            else
              return -1;   
        }
       boolean check=true;
        for(int i=0;i<n-1;i++)
       {
           if(s.charAt(i)>s.charAt(i+1))
             {
                check=false;
                break;
             }    
       }
       if(check)
         return 0;
        
       int freq[]=new int[26];
       for(char ch:s.toCharArray())
       {
           freq[ch-'a']++;
       }
       char min='1';
       for(int i=0;i<26;i++)
       {
            if(freq[i]!=0)
            {
                min=(char)(i+'a');
                break;
            }   
       }
       char max='1';   
       for(int i=25;i>=0;i--)
       {
            if(freq[i]!=0)
            {
                max=(char)(i+'a');
                break;
            }   
       }

       if(s.charAt(0)==min||s.charAt(n-1)==max)
         return 1;
        if(s.charAt(0)==max&&freq[max-'a']==1&&s.charAt(n-1)==min&&freq[min-'a']==1)
         return 3;
        return 2; 
       


        
    }
}