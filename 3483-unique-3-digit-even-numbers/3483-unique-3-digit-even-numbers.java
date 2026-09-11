class Solution {
    int help(int freq[],int d)
    {
        if(d==3)
           return 1;
        int total=0;
        for(int i=0;i<=9;i++)
        {
            if(d==0)
            {
                if(i%2==0&&freq[i]!=0)
                {
                    freq[i]--;
                   total+= help(freq,d+1);
                    freq[i]++;
                }
            }
            else if(d==2)
            {
                if(i==0)
                   continue;
                if(freq[i]!=0)
                {
                    freq[i]--;
                    total+=help(freq,d+1);
                    freq[i]++; 
                }   
            }
            else
            {
                if(freq[i]!=0)
                {
                    freq[i]--;
                   total+=help(freq,d+1);
                    freq[i]++; 
                } 

            }
        }
        return total;   

    }
    public int totalNumbers(int[] digits) {
        int freq[]=new int [10];
        for(int i:digits)
           freq[i]++;
        return help(freq,0);   
         
    }
}