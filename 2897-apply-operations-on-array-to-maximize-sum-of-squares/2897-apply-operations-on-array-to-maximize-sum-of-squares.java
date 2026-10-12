class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int n=nums.size();
        int bits[]=new int [32];
        int mod=1000000007;
        for(int i=0;i<n;i++)
        {
            int num=nums.get(i);
            int idx=0;
            while(num!=0)
            {
                int bit=num&1;
                bits[idx++]+=bit;
                num=num>>1; 
            }
        }
        long ans=0;

        while(k--!=0)
        {
            long num=0;
            for(int i=0;i<32;i++)
            {
                if(bits[i]!=0)
                {
                    bits[i]--;
                    num=num|(1<<i);
                }
            }
            ans+=(num*num)%mod;
            
        }
        return (int)(ans%mod);
    }
}