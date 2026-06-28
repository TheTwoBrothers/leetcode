class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans=0;
         int n=nums.length-1;


        while(k>0)
        {
                                                             
             long value=nums[n];
               if(mul>0)
                  value*=mul;
                  

             ans+=value;
             k--;
             n--;
             mul--;
        }
        return ans;
    }
}