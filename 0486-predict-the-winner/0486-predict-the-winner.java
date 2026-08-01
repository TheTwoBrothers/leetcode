class Solution {
    Integer dp[][][];
    int help(int x,int y,int turn,int nums[])
    {
        if(x>y)
          return 0;

        if(dp[x][y][turn]!=null)
           return dp[x][y][turn];
        int next_turn=turn==0?1:0;
        int left=0;
        int right=0;
        if(turn ==0)
        {
             left=help(x+1,y,next_turn,nums)+nums[x];
             right=help(x,y-1,next_turn,nums)+nums[y];
        }
        else
        {
            left=help(x+1,y,next_turn,nums)-nums[x];
            right=help(x,y-1,next_turn,nums)-nums[y];
        }     

        return dp[x][y][turn]=turn==0?Math.max(left,right):Math.min(left,right);  


    } 
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
       dp=new Integer [n][n][2];
    //    int sum=0;
    //    for(int x:nums)
    //        sum+=x;
    //     int first=help(0,n-1,0,nums);
    //     System.out.println(sum+"  "+first);
        return help(0,n-1,0,nums)>=0;   
    }
}