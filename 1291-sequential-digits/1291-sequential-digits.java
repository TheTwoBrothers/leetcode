class Solution {
    List<Integer> ans;
    void help(int low,int high,int x,int i,int num,int prev)
    {
         if(x==i)
         {
            if(num>=low)
            ans.add(num);
            return;
         }

         for(int j=1;j<=9;j++)
         {
            if(prev+1!=j&&prev!=-1)
               continue;
            int old=num;
            num=num*10+j;
            if(num>high)
               return; 
            help(low,high,x+1,i,num,j);
            num=old;             
         }

    }
    public List<Integer> sequentialDigits(int low, int high) {
      ans=new ArrayList<>();
       int st=(int) Math.log10(low) + 1;
       int ed=(int) Math.log10(high) + 1;
        for(int i=st;i<=ed;i++)
        {
           help(low,high,0,i,0,-1); 
        }
        return ans;
    }
}