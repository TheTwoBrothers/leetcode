class Solution {
    char arr[];
    void reverse(int st,int end)
    {
        // IO.println(st+" -- "+end); 
        // int s=st;
        // int e=end;   
        while(st<end)
        {
            char temp=arr[end];
            arr[end]=arr[st];
            arr[st]=temp;
            st++;
            end--;
        }
        // for(int i=s;i<=e;i++)
        //     IO.print(arr[i]);
        // IO.println("\n"+s+" -- "+e);    
    }
    void help(int idx,int n)
    {
         if(idx==n)
            return;

        for( int i=idx;i<n;i++)
        {
            char ch=arr[i];
            if(ch=='(')
            {
                arr[i]='_';
                help(i+1,n);
            }
            else if(ch==')')
            {
                arr[i]='_';
                reverse(idx,i-1);
                return;
            }
        }    

    }
    public String reverseParentheses(String s) {
        Stack<Character>st=new Stack<>();
        StringBuilder ans=new StringBuilder();
         arr=s.toCharArray();
        int n=s.length();
        help(0,n);
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]!='_')
            ans.append(arr[i]);
        }
        return ans.toString();

        
       
    
    }
}