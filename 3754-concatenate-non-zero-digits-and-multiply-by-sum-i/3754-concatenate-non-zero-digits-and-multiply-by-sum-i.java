class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;

        long x=0;
        int pow=0;
        while(n!=0)
        {
            int r=n%10;
            n/=10;
            if(r==0)
               continue;
            x+=(long)Math.pow(10,pow)*r;
            sum+=r;
            pow++;
        }
        // System.out.println(sum+"    "+x);
        return x*sum;
    }
}