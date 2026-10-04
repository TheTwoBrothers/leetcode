class Solution {
    public boolean checkValidString(String s) {
        // Stack<Character> stack=new Stack<>();
        //  int axt=0;
        // for(int i=0;i<s.length();i++)
        // {
        //     char ch=s.charAt(i);
        //     if(ch=='*')
        //        axt++;
        //     else if(ch=='(')
        //        stack.push(ch);
        //     else
        //     {
        //         if(stack.isEmpty()&&axt==0)
                
        //             return false;
        //         else if(stack.isEmpty())
        //                 axt--;
        //         else
        //             stack.pop();
        //     }        
        // } 
        //  if(stack.size()!=0)
        //      return false;
    
        //  return true;

        int min=0;
        int max=0;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if('('==ch)
            {
                min++;
                max++;
            }
            else if(')'==ch)
            {
                min--;
                max--;
            }
            else
            {
                min--;
                max++;
            }
            if(min<0)
               min=0;
            if(max<0)
               return false;

        }
        return min==0;
    }
}