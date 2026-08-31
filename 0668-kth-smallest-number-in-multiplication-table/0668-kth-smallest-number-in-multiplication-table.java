class Solution {
    int count(int x,int n,int m)
    {
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans+=Math.min(m,x/i);
        }
        return ans;
    }
    public int findKthNumber(int m, int n, int k) {
        int l=1;
        int h=n*m;

        while(l<h)
        {
            int mid=l+(h-l)/2;
            int x=count(mid,n,m);

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