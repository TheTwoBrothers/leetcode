class Solution {
    long count(long x,int coins[])
    {
        int n=coins.length;
        long ans=0;
        for(int mask=1;mask<(1<<n);mask++)
        {
            int bits=0;
            long lcm=1;
            boolean valid=true;
            for(int i=0;i<n;i++)
            {
                if((mask&(1<<i))!=0)
                {
                    bits++;
                    lcm=lcm(lcm,coins[i]);

                    if(lcm>x)
                    {
                        valid=false;
                        break;
                    }
                }
            }
            if(valid)
            {
                if(bits%2==0)
                {
                    ans-=x/lcm;
                }
                else
                {
                    ans+=x/lcm;
                }
            }
        }
        return ans;
    }
        long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long findKthSmallest(int[] coins, int k) {
       Arrays.sort(coins);
       int n=coins.length;
       long l=coins[0]; 
       long h=(long)k*coins[0];

       while(l<h)
       {
            long mid=(h+l)/2;

            long x=count(mid,coins);
            if(x>=k)
            {
                h=mid;
            }
            else
            {
                l=mid+1;
            }
            
       }
       return l; 
    }
}