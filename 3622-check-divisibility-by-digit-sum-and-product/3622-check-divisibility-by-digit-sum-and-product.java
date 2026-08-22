class Solution {
    public boolean checkDivisibility(int n) {
        long sum=0;
        long prod=1;
        long num=n;
        while(n>0)
        {
            sum+=n%10;
            prod*=n%10;
            n/=10;
        }
        return num%(sum+prod)==0;
    }
}