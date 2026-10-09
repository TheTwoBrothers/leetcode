class Solution {
    public int minInsertions(String s) {
        int idx=-1;
        int score=0;
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            score+=2;
            else 
            {
                if(i!=n-1)
                {
                    int penalty=0;
                    if(s.charAt(i+1)!=')')
                    {
                        penalty++;
                    }
                    if(score==0)
                    {
                        ans+=penalty+1;

                    }
                    else
                    {
                        score-=2;
                        ans+=penalty;
                    }   

                    i+=penalty==1?0:1;     
                }
                else
                {
                   if(score==0)
                      ans+=2;
                    else
                      score--;   
                }
            }

        }
        return ans+score;
    }
}