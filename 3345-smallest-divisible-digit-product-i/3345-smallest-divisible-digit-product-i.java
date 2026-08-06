class Solution {
    public int smallestNumber(int n, int t) {

        while(true)
        {
            int temp=n;
            int product=1;

            while(temp!=0)
            {
                int mod=temp%10;
                temp/=10;
                product=product*mod;
            }
            if(product%t==0)
               return n;
            n++;   

        }
    }
}