class Solution
{
    public long maximumOr(int[] nums, int k)
    {
        long ans = 0;
        int bits[] = new int[64];
        long or=0;
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < 32; j++)
            {
                int bit =(nums[i]>>j)&1;
                bits[j] += bit;
                or|=bit<<j;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            long total=or;
            

            for(int j=0;j<32;j++)
            {
                int bit =(nums[i]>>j)&1;
                if(bit==1&&bits[j]==1)
                {
                    total^=(1<<j);
                }
            }
            long num=(1L*nums[i]<<k);
            long result=num|total;
            ans=Math.max(ans,result);
            
            
        }
        return ans;
       
    }
}

