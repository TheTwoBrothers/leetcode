class Solution {
    public String maxSumOfSquares(int num, int sum) {

        StringBuilder sb=new StringBuilder();

        while(sum!=0)
        {
            if(sum<9)
            {
                sb.append((char)(sum+'0'));
                sum=0;
            }
            else
            {
                sb.append('9');
                sum-=9;
            }
        }
        if(sb.length()>num)
           return "";
        int len=sb.length();
        for(int i=len;i<num;i++)
            sb.append('0');
        return sb.toString();       

    }
}