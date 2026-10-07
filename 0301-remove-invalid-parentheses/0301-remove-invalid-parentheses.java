class Solution {
    int len;
    HashSet<String>ans;
    boolean check(StringBuilder sb)
    {
        if(sb.length()==0)
           return true;
          
        Stack<Character>st=new Stack<>();
        

        for(int i=0;i<sb.length();i++)
        {
            char ch=sb.charAt(i);

            if(ch=='(')
              st.push(ch);
            else if( ch==')')
             {
                if(st.isEmpty())
                   return false;
                st.pop();   
             }   
        }
        return st.size()==0; 
        
    }
    void help(StringBuilder sb,int i,String s)
    {
         if(i>=s.length())
         {
             if(check(sb))
             {
                if(sb.length()==len)
                {
                    ans.add(sb.toString());
                }
                else if(sb.length()>len)
                {
                    len=sb.length();
                    ans=new HashSet<>();
                    ans.add(sb.toString());
                }
             }
             return;
         }
            if(s.charAt(i)>='a'&&s.charAt(i)<='z')
            {
                sb.append(s.charAt(i));
                 help(sb,i+1,s);
                sb.deleteCharAt(sb.length() - 1); 
            }     
            else{
            sb.append(s.charAt(i));
            help(sb,i+1,s);
            sb.deleteCharAt(sb.length() - 1);
            help(sb,i+1,s);
            }
    }

    public List<String> removeInvalidParentheses(String s) {
        ans=new HashSet<>();
        int len=-1;
        help(new StringBuilder(),0,s);
        return new ArrayList(ans);
    }
}